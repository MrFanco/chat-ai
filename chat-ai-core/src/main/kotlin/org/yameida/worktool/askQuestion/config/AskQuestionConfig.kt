package org.yameida.worktool.askQuestion.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @Author genxm
 * @Description 问题核心配置类
 * @Date 2023/2/13 12:25
 * @Version 1.0
 */

@Configuration
open class AskQuestionConfig {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)


    @Bean("questionCore")
    @ConditionalOnMissingBean(name = ["questionCore"])
    open fun questionCore(): QuestionCore {
        logger.info("questionCore : 开启问题询问线程和错误消息重问线程")
        return QuestionCore.get().startQuestion()
    }
}