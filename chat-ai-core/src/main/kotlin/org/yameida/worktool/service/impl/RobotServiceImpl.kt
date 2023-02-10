package org.yameida.worktool.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.yameida.worktool.common.redis.RedisCache
import org.yameida.worktool.common.utils.StringUtils
import org.yameida.worktool.data.domain.ChatRobotInfo
import org.yameida.worktool.data.service.ChatRobotInfoService
import org.yameida.worktool.service.RobotService

@Service
open class RobotServiceImpl(
    private val redisCache: RedisCache,
    private val chatRobotInfoService: ChatRobotInfoService
) : RobotService {

    @Value("\${chat-ai.redis-key.robot}")
    lateinit var robotKey: String

    override fun exits(robotId: String): Boolean {
        require(StringUtils.isNotBlank(robotId)) { "机器人id不能为空" }
        val key = robotKey + robotId
        var robotInfo = redisCache.getCacheObject<ChatRobotInfo>(key)
        if (null != robotInfo) return true

        robotInfo = chatRobotInfoService.findByRobotId(robotId) ?: return false

        //查询到设置缓存
        redisCache.setCacheObject(key, robotInfo)
        return true
    }

    override fun getKey(robotId: String): String? {
        val key = robotKey + robotId;
        var robotInfo = redisCache.getCacheObject<ChatRobotInfo>(key)

        if (null != robotInfo) return robotInfo.robotKey

        robotInfo = chatRobotInfoService.findByRobotId(robotId) ?: return null

        //查询到设置缓存
        redisCache.setCacheObject(key, robotInfo)

        return robotInfo.robotKey
    }

}