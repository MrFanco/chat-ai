package org.yameida.worktool.service

/**
 * @Author genxm
 * @Description 机器人业务类
 * @Date 2023/2/9 18:21
 * @Version 1.0
 */
interface RobotService {
    /**
     * 判断机器人是已经配置
     */
    fun exits(robotId: String): Boolean

    /**
     * 获取机器人校验key
     */
    fun getKey(robotId: String): String?
}