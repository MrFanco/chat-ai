package org.yameida.worktool.common.msgBean;

import lombok.Data;

/**
 * @Author genxm
 * @Description 输入消息实体
 * @Date 2022/12/16 10:33
 * @Version 1.0
 */
@Data
public class InputMsgBean {


    private String spoken;

    private String rawSpoken;

    private String receivedName;

    private String groupName;

    private String groupRemark;
    /**
     * QA所在房间类型 1=外部群 2=外部联系人 3=内部群 4=内部联系人
     */
    private Integer roomType;

    private boolean atMe;

    private Integer textType;
}
