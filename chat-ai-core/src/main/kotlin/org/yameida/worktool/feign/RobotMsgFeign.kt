package org.yameida.worktool.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.yameida.worktool.common.api.CommonResult
import org.yameida.worktool.common.msgBean.RobotMgsItem
import org.yameida.worktool.common.msgBean.WeworkMessageListBean

/**
 * @Author genxm
 * @Description 机器人发送消息
 * @Date 2022/12/15 15:02
 * @Version 1.0
 */
@FeignClient(name = "robotRawMSg", url = "\${workTool.server}", path = "/wework/")
interface RobotMsgFeign {
    /**
     * 发送指令信息
     *
     * @param robotId
     * @param key
     * @return
     */
    @PostMapping("sendRawMessage")
    fun sendRawMessage(
        @RequestParam("robotId") robotId: String,
        @RequestParam("key") key: String,
        @RequestBody msg: WeworkMessageListBean
    ): CommonResult<Any>

    /**
     * 批量发送信息系
     * @param list
     * @return
     */
    @PostMapping("sendMsgMulti")
    fun sendMsgMulti(@RequestBody list: List<RobotMgsItem>): CommonResult<Map<Int, String>>
}