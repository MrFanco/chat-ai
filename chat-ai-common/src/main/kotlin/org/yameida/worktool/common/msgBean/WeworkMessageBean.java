package org.yameida.worktool.common.msgBean;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WeworkMessageBean {

    public Boolean up;
    //标题 通常是群名或联系人
    public List<String> titleList;
    //上传聊天列表
    public List<SubMessageBean> messageList;
    //上传日志内容
    public String log;
    //外部群1 外部联系人2 内部群3 内部联系人4
    public Integer roomType;

    //原生消息,消息确认回调使用
    public String rawMsg;
    //指令是否成功 1成功 0失败
    public Integer errorCode;
    //错误原因
    public String errorReason;
    //指令执行时间
    public Long runTime;
    //执行耗时
    public Double timeCost;

    //接收人名称
    public String receivedName;
    //发送：回复的消息内容
    public String receivedContent;

    //想要at的昵称
    public String at;
    //想要at的昵称列表
    public List<String> atList;
    //去除atMe的消息内容
    public String originalContent;
    //原始消息，未移除@me消息的原始消息
    public String rawSpoken;
    //多选(转发等)
    public List<String> nameList;
    //转发附加留言
    public String extraText;
    //接收消息类型
    public int textType;
    //群名
    public String groupName;
    //群主名称
    public String groupOwner;
    //成员名单
    public List<String> selectList;
    //成员数
    public Integer groupNumber;
    //群公告
    public String groupAnnouncement;
    //新群名
    public String newGroupName;
    //新群公告
    public String newGroupAnnouncement;
    //群备注
    public String groupRemark;
    //群模板
    public String groupTemplate;

    //踢人列表
    public List<String> removeList;
    //拉人是否附带历史记录
    public Boolean showMessageHistory;
    //我的信息
    public MyInfo myInfo;
    //对象名称(图片、文件、小程序等)
    public String objectName;

    public String file_base64_content;

    //网络文件
    public String fileUrl;
    public String fileType;
    //二维码转码
    public String qrcode;
    //添加好友
    public Friend friend;

    public String hearBeat;

    public int type = 0;
    //成功清单
    public List<String> successList;
    //失败清单
    public List<String> failList;

    //消息列表的每条消息
    @Data
    @NoArgsConstructor
    public static class SubMessageBean {
        //0其他人 1机器人自己 2unknown(如系统消息)
        public int sender = 0;
        public List<ItemMessageBean> itemMessageList;
        public List<String> nameList;
        //消息类型判断 仅针对sender=0
        public int textType;


        public SubMessageBean(int sender, List<ItemMessageBean> itemMessageList, List<String> nameList) {
            this.sender = sender;
            this.itemMessageList = itemMessageList;
            this.nameList = nameList;
        }
    }

    //消息列表每条消息的text推断
    @Data
    @NoArgsConstructor
    public static class ItemMessageBean {
        //0消息主体上方信息 如日期等 系统消息(拉人/撤回/外部群等居中的提示语)
        //2消息内容
        public int feature = 0;
        public String text;

        public ItemMessageBean(int feature, String text) {
            this.feature = feature;
            this.text = text;
        }
    }

    //我的信息
    @Data
    @NoArgsConstructor
    public static class MyInfo {
        //{姓名, 工作签名, 手机, 别名, 对外信息显示}
        public String name;
        public String alias;
        public String gender;
        public String showName;
        public String workSign;
        public String corporation;
        public String phone;
        public String job;
        public String sumInfo;
    }

    //添加好友
    @Data
    @NoArgsConstructor
    public static class Friend {
        //按手机号搜索
        public String phone;
        //好友姓名
        public String name;
        //备注名
        public String markName;
        //留言
        public String leavingMsg;
        //备注企业
        public String markCorp;
        //备注更多描述
        public String markExtra;
        //备注标签(推荐)
        public List<String> tagList;
        //是否是新朋友
        private boolean newFriend;
    }
}
