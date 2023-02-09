
package org.yameida.worktool.common.msgBean;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yameida.worktool.common.constants.MessageType;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class WeworkMessageListBean {


    private int socketType = MessageType.SOCKET_TYPE_MESSAGE_LIST;
    /**
     * 0 是后台消息，1是APi手动调用
     */
    private int apiSend = 0;
    /**
     * 消息id
     */
    private String messageId = IdUtil.getSnowflakeNextIdStr();


    /**
     * 消息列表
     */
    private ArrayList<WeworkMessageBean> list = new ArrayList<>();

    public WeworkMessageListBean(WeworkMessageBean weworkMessageBean, int type, int apiSend) {
        list.add(weworkMessageBean);
        this.socketType = type;
        this.apiSend = apiSend;
    }

    public WeworkMessageListBean(WeworkMessageBean weworkMessageBean) {
        list.add(weworkMessageBean);
        this.socketType = MessageType.SOCKET_TYPE_MESSAGE_LIST;
    }

    public WeworkMessageListBean(List<WeworkMessageBean> weworkMessageBeanList, int type, int apiSend) {
        list.addAll(weworkMessageBeanList);
        this.socketType = type;
        this.apiSend = apiSend;
    }


    public int getSocketType() {
        return socketType;
    }

    public String getMessageId() {
        return messageId;
    }

    public ArrayList<WeworkMessageBean> getList() {
        return list;
    }

    public void setSocketType(int socketType) {
        this.socketType = socketType;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setList(ArrayList<WeworkMessageBean> list) {
        this.list = list;
    }
}