package org.yameida.worktool.service.impl

import cn.hutool.core.collection.CollectionUtil
import com.alibaba.fastjson2.JSONObject
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.yameida.worktool.common.domain.AIAnswer
import org.yameida.worktool.common.domain.Choices
import org.yameida.worktool.common.redis.RedisCache
import org.yameida.worktool.data.domain.ChatAi
import org.yameida.worktool.data.service.ChatAiService
import org.yameida.worktool.service.AIService

@Service
class AIServiceImpl(
    private val chatAiService: ChatAiService,
    private val redisCache: RedisCache

) : AIService {

    @Value("\${chat-ai.redis-key.AIList}")
    lateinit var AIListKey: String


    @Value("\${chat-ai.redis-key.AIHost}")
    lateinit var AIHost: String


    override fun getAIs(): MutableList<ChatAi> {
        var AIList = redisCache.getCacheList<ChatAi>(AIListKey)
        if (CollectionUtil.isEmpty(AIList)) {
            AIList = chatAiService.list()
            if (CollectionUtil.isNotEmpty(AIList)) {
                redisCache.setCacheList(AIListKey, AIList)
            }
        }
        return AIList
    }

    override fun getAnswer(question: String, ai: ChatAi): String? {
        val httpClient = HttpClientBuilder.create().build()
        val post = HttpPost(AIHost)
        post.addHeader("Content-Type", "application/json")
        post.addHeader("Authorization", "Bearer ${ai.apiKey}")
        post.addHeader("OpenAI-Organization", ai.organization )
        val paramJson =
            "{\"model\": \"text-davinci-003\", \"prompt\": \"$question\", \"temperature\": 0, \"max_tokens\": 1024}"

        val stringEntity = StringEntity(paramJson, ContentType.create("text/json", "UTF-8"))
        post.entity = stringEntity

        val response = httpClient.execute(post)
        return if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            val jsonStr = EntityUtils.toString(response.entity)
            val aiAnswer: AIAnswer = JSONObject.parseObject(jsonStr, AIAnswer::class.java)
            val answers = StringBuilder()
            val choices: List<Choices> = aiAnswer.getChoices()
            for (choice in choices) {
                answers.append(choice.getText())
            }
            answers.toString()
        } else {
            throw RuntimeException("api.openai.com Err Code is " + response.statusLine.statusCode)
        }
    }
}