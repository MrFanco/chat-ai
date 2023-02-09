package org.yameida.worktool.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.yameida.worktool.common.api.CommonResult
import org.yameida.worktool.common.domain.RobotInfo

/**
 * @Author genxm
 * @Description 机器人信息
 * @Date 2022/12/15 15:02
 * @Version 1.0
 */
@FeignClient(name = "robotInfoFeign", url = "\${workTool.server}", path = "/robot/")
interface RobotInfoFeign {
    /**
     * 发送指令信息
     *
     * @param robotId
     * @param key
     * @return
     */
    @GetMapping("robotInfo/get")
    fun getInfo(@RequestParam("robotId") robotId: String, @RequestParam("key") key: String): CommonResult<RobotInfo>
}
