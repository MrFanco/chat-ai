package org.yameida.worktool.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.yameida.worktool.common.domain.RobotInfo
import org.yameida.worktool.common.redis.RedisCache
import org.yameida.worktool.common.utils.StringUtils
import org.yameida.worktool.service.RobotService

@Service
class RobotServiceImpl(val redisCache: RedisCache) : RobotService {

    @Value("\${chat-ai.redis-key.robot}")
    lateinit var robotKey: String

    override fun exits(robotId: String): Boolean {
        require(StringUtils.isNotBlank(robotId)) { "机器人id不能为空" }
        val key = robotKey + robotId;
        redisCache.getCacheObject<RobotInfo>(key) ?: return false;
        return true
    }

}