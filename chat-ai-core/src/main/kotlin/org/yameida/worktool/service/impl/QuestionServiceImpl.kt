package org.yameida.worktool.service.impl

import com.alibaba.fastjson2.JSONObject
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.yameida.worktool.common.msgBean.InputMsgBean
import org.yameida.worktool.common.utils.StringUtils
import org.yameida.worktool.data.domain.ChatQuestion
import org.yameida.worktool.data.service.ChatQuestionService
import org.yameida.worktool.service.QuestionService

@Service
class QuestionServiceImpl(
    private val ChatQuestionService: ChatQuestionService,
    private val redisTemplate: StringRedisTemplate,
) : QuestionService {

    @Value("\${chat-ai.redis-key.questionQueue}")
    lateinit var questionQueue: String

    @Value("\${chat-ai.redis-key.errorQuestion}")
    lateinit var errorQuestion: String


    override fun saveQuestion(robotId: String, msg: InputMsgBean): ChatQuestion {
        val chatQuestion = ChatQuestion()
        BeanUtils.copyProperties(msg, chatQuestion)
        chatQuestion.robotId = robotId
        ChatQuestionService.save(chatQuestion)
        return chatQuestion
    }

    override fun addWaitAskContainer(question: ChatQuestion) {
        question.reTryCount++
        redisTemplate.opsForList().leftPush(questionQueue, JSONObject.toJSONString(question))
    }


    override fun getQuestionFromContainer(): ChatQuestion? {
        val msg = redisTemplate.opsForList().rightPop(questionQueue)
        if (StringUtils.isBlank(msg)) {
            return null
        }
        return JSONObject.parseObject(msg, ChatQuestion::class.java)
    }
}