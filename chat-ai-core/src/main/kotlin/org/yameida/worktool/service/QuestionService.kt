package org.yameida.worktool.service

import org.yameida.worktool.common.msgBean.InputMsgBean
import org.yameida.worktool.data.domain.ChatQuestion

/**
 * @Author genxm
 * @Description 问题服务类
 * @Date 2023/2/13 9:32
 * @Version 1.0
 */
interface QuestionService {

    /**
     * 往数据库存储数据,并返回带有id的数据
     */
    fun saveQuestion(robotId: String, msg: InputMsgBean): ChatQuestion

    /**
     * 往待问队列中添加数据
     */
    fun addWaitAskContainer(question: ChatQuestion)

    /**
     * 从待问容器中获取问题
     */
    fun getQuestionFromContainer(): ChatQuestion?


}