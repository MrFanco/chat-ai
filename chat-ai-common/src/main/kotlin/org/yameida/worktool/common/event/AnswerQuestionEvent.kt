package org.yameida.worktool.common.event

import org.springframework.context.ApplicationEvent
import org.yameida.worktool.common.msgBean.WeworkMessageListBean

/**
 * @Author genxm
 * @Description 回答问题事件
 * @Date 2023/2/9 18:24
 * @Version 1.0
 */
class AnswerQuestionEvent(
    private val robotId: String,
    private val msg: WeworkMessageListBean
) : ApplicationEvent(msg) {

    fun getMsg(): WeworkMessageListBean {
        return msg
    }

    fun getRobotId(): String {
        return robotId
    }
}
