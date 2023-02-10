package org.yameida.worktool.controller

import com.alibaba.fastjson2.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.*
import org.yameida.worktool.common.api.CommonResult
import org.yameida.worktool.common.event.AskQuestionEvent
import org.yameida.worktool.common.msgBean.InputMsgBean
import org.yameida.worktool.common.msgBean.ReplyMsg
import org.yameida.worktool.common.utils.StringUtils
import org.yameida.worktool.service.RobotService


/**
 * @Author genxm
 * @Description 消息输入接口
 * @Date 2022/12/16 10:08
 * @Version 1.0
 */
@RestController
@RequestMapping("chat-ai/ask")
class MsgAggregationController(val applicationContext: ApplicationContext, val robotService: RobotService) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun ask(@RequestParam("robotId") robotId: String, @RequestBody msg: InputMsgBean): CommonResult<ReplyMsg> {
        val exits = robotService.exits(robotId)
        val replyMsg = ReplyMsg()
        if (!exits) {
            replyMsg.setTest("请先绑定机器人id")
            logger.info("收到机器人id: $robotId 未绑定,跳过本次消息")
        } else {
            logger.info("收到机器人id: $robotId 的消息 {}", JSONObject.toJSONString(msg))
            applicationContext.publishEvent(AskQuestionEvent(robotId, msg))
        }
        return CommonResult.success(replyMsg)
    }

}