package org.yameida.worktool.service.impl

import cn.hutool.core.collection.CollectionUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
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
}