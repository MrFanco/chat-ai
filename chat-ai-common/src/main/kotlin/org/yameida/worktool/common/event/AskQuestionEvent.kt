package org.yameida.worktool.common.event

import org.springframework.context.ApplicationEvent
import org.yameida.worktool.common.msgBean.InputMsgBean

/**
 * @Author genxm
 * @Description 询问问题事件
 * @Date 2023/2/9 18:24
 * @Version 1.0
 */
class AskQuestionEvent(private val robotId: String, private val msg: InputMsgBean) : ApplicationEvent(msg) {

    fun getRobotId(): String {
        return this.robotId
    }

    fun getMsg(): InputMsgBean {
        return this.msg
    }
}
