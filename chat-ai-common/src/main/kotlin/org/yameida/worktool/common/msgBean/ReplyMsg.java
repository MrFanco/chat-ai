package org.yameida.worktool.common.msgBean;

import lombok.Data;

/**
 * @Author genxm
 * @Description 回复消息体格式
 * @Date 2022/12/16 10:15
 * @Version 1.0
 */
@Data
public class ReplyMsg {

    private Integer type = 5000;

    private Info info = new Info();

    public String getText() {
        return info.getText();
    }

    public void setTest(String text) {
        info.setText(text);
    }

    @Data
    public static class Info {
        private String text = "";
    }

}
