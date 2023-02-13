package org.yameida.worktool.listener

import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import org.yameida.worktool.common.event.AskQuestionEvent
import org.yameida.worktool.service.QuestionService

/**
 * @Author genxm
 * @Description 接收到问题事件监听器
 * @Date 2023/2/13 11:03
 * @Version 1.0
 */
@Component
class AskQuestionEventListener(
    private val questionService: QuestionService
) : ApplicationListener<AskQuestionEvent> {

    override fun onApplicationEvent(event: AskQuestionEvent) {
        val msg = event.getMsg()
        val robotId = event.getRobotId()
        //数据入库
        val saveQuestion = questionService.saveQuestion(robotId, msg)
        //往问题待问容器中添加问题
        questionService.addWaitAskContainer(saveQuestion)
    }
}