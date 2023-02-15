package org.yameida.worktool.askQuestion

import cn.hutool.core.collection.CollectionUtil
import com.alibaba.fastjson2.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.yameida.worktool.askQuestion.config.QuestionCore
import org.yameida.worktool.common.base.BaseHandler
import org.yameida.worktool.common.event.AnswerQuestionEvent
import org.yameida.worktool.common.event.DataUpdateEvent
import org.yameida.worktool.common.utils.MsgUtil
import org.yameida.worktool.common.utils.SpringUtils
import org.yameida.worktool.common.utils.ThreadPoolManager
import org.yameida.worktool.data.service.ChatQuestionService
import org.yameida.worktool.service.AIService
import org.yameida.worktool.service.QuestionService
import java.util.*

/**
 * @Author genxm
 * @Description 错误消息控制线程
 * @Date 2023/2/13 12:12
 * @Version 1.0
 */
open class QuestionAskHandler : BaseHandler("消息询问线程") {
    //睡眠系数,单位秒
    private val READ_MSG_TIME_INTERVAL: Long = 1

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    override fun handler() {

        val aIList = aIService().getAIs()
        if (CollectionUtil.isEmpty(aIList)) {
            logger.info("无可用AI,请配置ai机器人,系统休眠 $READ_MSG_TIME_INTERVAL 秒钟")
        }

        val question = questionService().getQuestionFromContainer()
        if (question == null) {
            logger.info("无待询问问题,休眠 $READ_MSG_TIME_INTERVAL 秒钟")
            sleep(READ_MSG_TIME_INTERVAL)
            return
        }
        //如果消息重试次数大于4次就丢弃
        if (question.reTryCount > 8) {
            logger.info("消息重试次数大于8次,丢弃 ${JSONObject.toJSONString(question)} 秒钟")
            return
        }

        //计算使用哪个机器
        val hashCode = Math.abs(question.robotId.hashCode())
        val index = hashCode % aIList.size
        val ai = aIList[index]

        val askTime = System.currentTimeMillis()
        //获取上次询问时间
        val lastTime = questionCore().getAIUseAITime(ai.id)

        //判断当前机器人能否使用 基础间隔时间未5秒 随机打样
        if (Random().nextBoolean() && askTime - lastTime > 5000) {
            logger.info("ai id为 :${ai.id} 暂时不能使用,消息重新加入到消息队列中 ")
            //消息如果4次不能询问成功就丢弃
            questionService().addWaitAskContainer(question)
            sleep(READ_MSG_TIME_INTERVAL)
            return
        }
        val answerTime = System.currentTimeMillis()
        ThreadPoolManager.getInstance().execute {
            question.answer = aIService().getAnswer(question.spoken, ai)
            //询问时间
            logger.info("ai编号:${ai.id} 消息询问中-----------------------")
            question.costTime = (answerTime - askTime).toInt()
            logger.info("ai编号:${ai.id} 消息询结束-----------------------")
            //产生新的消息体
            val msg = MsgUtil.initMsg(question.answer, question.groupRemark, question.groupName, question.receivedName)
            SpringUtils.getApplicationContext().publishEvent(AnswerQuestionEvent(question.robotId, msg))
            //更新问题数据库
            SpringUtils.getApplicationContext().publishEvent(DataUpdateEvent(question, ChatQuestionService::class.java))
        }
        //更新AI使用时间
        questionCore().updateAIUseTime(ai.id, answerTime)
        sleep(READ_MSG_TIME_INTERVAL)
    }

    open fun questionService(): QuestionService {
        return SpringUtils.getBean(QuestionService::class.java);
    }

    open fun aIService(): AIService {
        return SpringUtils.getBean(AIService::class.java);
    }


    open fun questionCore(): QuestionCore {
        return SpringUtils.getBean(QuestionCore::class.java);
    }
}