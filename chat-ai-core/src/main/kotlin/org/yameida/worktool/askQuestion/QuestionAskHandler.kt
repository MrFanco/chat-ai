package org.yameida.worktool.askQuestion

import org.yameida.worktool.common.base.BaseHandler
import org.yameida.worktool.common.utils.SpringUtils
import org.yameida.worktool.service.QuestionService

/**
 * @Author genxm
 * @Description 错误消息控制线程
 * @Date 2023/2/13 12:12
 * @Version 1.0
 */
open class QuestionAskHandler : BaseHandler("消息询问线程") {

    private val READ_MSG_TIME_INTERVAL: Long = 200

    private  val questionService = SpringUtils.getBean(QuestionService::class.java)

    override fun handler() {





        sleep(READ_MSG_TIME_INTERVAL)



    }


}