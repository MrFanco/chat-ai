package org.yameida.worktool.listener;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.yameida.worktool.common.api.CommonResult;
import org.yameida.worktool.common.event.AnswerQuestionEvent;
import org.yameida.worktool.common.event.DataSaveEvent;
import org.yameida.worktool.data.domain.MsgLog;
import org.yameida.worktool.data.service.MsgLogService;
import org.yameida.worktool.feign.RobotMsgFeign;
import org.yameida.worktool.service.RobotService;

import javax.annotation.Resource;

/**
 * @Author genxm
 * @Description 回答消息
 * @Date 2023/2/10 17:40
 * @Version 1.0
 */
@Log4j2
@Component
public class AnswerQuestionEventListener implements ApplicationListener<AnswerQuestionEvent> {

    @Resource
    private RobotMsgFeign robotMsgFeign;

    @Resource
    private RobotService robotService;

    @Resource
    private ApplicationContext applicationContext;


    @Override
    public void onApplicationEvent(AnswerQuestionEvent event) {
        String robotId = event.getRobotId();
        String key = robotService.getKey(robotId);

        CommonResult<Object> result = robotMsgFeign.sendRawMessage(robotId, key, event.getMsg());
        String msg = JSONObject.toJSONString(event.getMsg());
        String response = JSONObject.toJSONString(result);
        log.info("机器人: {} 发送消息: {} 返回结结果为: {}", robotId, msg, response);

        MsgLog.MsgLogBuilder builder = MsgLog.builder().robotId(robotId).msg(msg).response(response);
        if (result != null && result.getCode() != 200) {
            builder.errorCode((int) result.getCode()).errorReason(result.getMessage());
        }
        MsgLog data = builder.build();

        applicationContext.publishEvent(new DataSaveEvent(data, MsgLogService.class));
    }

}
