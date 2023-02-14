package org.yameida.worktool.common.utils;


import org.yameida.worktool.common.msgBean.WeworkMessageBean;
import org.yameida.worktool.common.msgBean.WeworkMessageListBean;

import java.util.Collections;

import static org.yameida.worktool.common.constants.MessageType.SEND_MESSAGE;

/**
 * @Author genxm
 * @Description 生成消息工具类
 * @Date 2022/12/15 10:37
 * @Version 1.0
 */
public class MsgUtil {


    public static WeworkMessageListBean initMsg(String answer, String groupRemark, String groupName, String receivedName) {

        String targetName = StringUtils.isNotBlank(groupRemark) ? groupRemark : groupName;

        targetName = StringUtils.isNotBlank(targetName) ? targetName : receivedName;


        WeworkMessageListBean weworkMessageListBean = new WeworkMessageListBean();
        WeworkMessageBean msg = new WeworkMessageBean();
        msg.type = SEND_MESSAGE;
        msg.titleList = Collections.singletonList(targetName);
        msg.receivedContent = answer;
        weworkMessageListBean.getList().add(msg);
        return weworkMessageListBean;
    }
}
