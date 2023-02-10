package org.yameida.worktool.listener

import lombok.extern.slf4j.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.yameida.worktool.common.event.AskQuestionEvent


/**
 * @Author genxm
 * @Description 消息输入监听器
 * @Date 2022/12/16 10:55
 * @Version 1.0
 */
@Slf4j
@Component
open class AskQuestionEventListener : ApplicationListener<AskQuestionEvent> {

    @Async
    override fun onApplicationEvent(event: AskQuestionEvent) {

    }

}