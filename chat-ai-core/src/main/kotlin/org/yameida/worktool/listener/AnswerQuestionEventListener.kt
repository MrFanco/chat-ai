package org.yameida.worktool.listener

import com.alibaba.fastjson2.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import org.yameida.worktool.common.event.AnswerQuestionEvent
import org.yameida.worktool.common.event.DataSaveEvent
import org.yameida.worktool.data.domain.MsgLog
import org.yameida.worktool.data.service.MsgLogService
import org.yameida.worktool.feign.RobotMsgFeign
import org.yameida.worktool.service.RobotService
import javax.annotation.Resource

/**
 * @Author genxm
 * @Description 回答消息
 * @Date 2023/2/10 17:40
 * @Version 1.0
 */
@Component
class AnswerQuestionEventListener(
    private val robotMsgFeign: RobotMsgFeign,
    private val robotService: RobotService
) : ApplicationListener<AnswerQuestionEvent> {


    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Resource
    private val applicationContext: ApplicationContext? = null
    override fun onApplicationEvent(event: AnswerQuestionEvent) {
        val robotId = event.getRobotId()
        val key = robotService.getKey(robotId)
        val result = robotMsgFeign.sendRawMessage(robotId, key, event.getMsg())
        val msg = JSONObject.toJSONString(event.getMsg())
        val response = JSONObject.toJSONString(result)
        logger.info("机器人: $robotId 发送消息: $msg 返回结结果为: $response", robotId, msg, response)
        val builder = MsgLog.builder().robotId(robotId).msg(msg).response(response)
        if (result != null && result.code != 200L) {
            builder.errorCode(result.code.toInt()).errorReason(result.message)
        }
        val data = builder.build()
        applicationContext!!.publishEvent(DataSaveEvent(data, MsgLogService::class.java))
    }
}