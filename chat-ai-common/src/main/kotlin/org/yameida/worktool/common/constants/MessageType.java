package org.yameida.worktool.common.constants;

/**
 * @author 梁逸
 * @date 2022/3/28 10:23
 */
public class MessageType {

    /**
     * type
     * <p>
     * 消息类型10
     * 心跳 HEART_BEAT
     * <p>
     * 消息类型 100
     * 上传消息列表 TYPE_RECEIVE_MESSAGE_LIST
     * 吐司消息 TYPE_CONSOLE_TOAST
     * <p>
     * 全局操作类型 200
     * 停止所有任务并返回首页待命 STOP_AND_GO_HOME
     * 回到首页等待接收新消息 LOOP_RECEIVE_NEW_MESSAGE
     * 在房间内发送消息 SEND_MESSAGE
     * 在房间内指定回复消息 REPLY_MESSAGE
     * 在房间内转发消息 RELAY_MESSAGE
     * 创建群 INIT_GROUP
     * 进入群聊并修改群配置 INTO_GROUP_AND_CONFIG
     * 推送微盘图片 PUSH_MICRO_DISK_IMAGE
     * 推送微盘文件 PUSH_MICRO_DISK_FILE
     * 推送任意小程序 PUSH_MICROPROGRAM
     * 推送腾讯文档 PUSH_OFFICE
     * 通过当前所有好友请求 PASS_ALL_FRIEND_REQUEST
     * 按手机号添加好友 ADD_FRIEND_BY_PHONE
     * 展示群信息 SHOW_GROUP_INFO
     * 新增防骚扰规则 INIT_ANTI_HARASSMENT_RULE
     * 推送文件 PUSH_FILE
     * <p>
     * 非操作类型 300
     * 机器人普通日志记录 ROBOT_LOG
     * 机器人异常日志记录 ROBOT_ERROR_LOG
     * 机器人接口测试 ROBOT_CONTROLLER_TEST
     * <p>
     * 获取数据类型 500
     * 获取群信息 GET_GROUP_INFO
     * 获取好友信息 GET_FRIEND_INFO
     * 获取我的信息 GET_MY_INFO
     */
    public static final int HEART_BEAT = 11;
    public static final int TYPE_RECEIVE_MESSAGE_LIST = 101;

    public static final int TYPE_CONSOLE_TOAST = 102;

    public static final int STOP_AND_GO_HOME = 201;
    public static final int LOOP_RECEIVE_NEW_MESSAGE = 202;
    public static final int SEND_MESSAGE = 203;
    public static final int REPLY_MESSAGE = 204;
    public static final int RELAY_MESSAGE = 205;
    public static final int INIT_GROUP = 206;
    public static final int INTO_GROUP_AND_CONFIG = 207;
    public static final int PUSH_MICRO_DISK_IMAGE = 208;
    public static final int PUSH_MICRO_DISK_FILE = 209;
    public static final int PUSH_MICROPROGRAM = 210;
    public static final int PUSH_OFFICE = 211;
    public static final int PASS_ALL_FRIEND_REQUEST = 212;
    public static final int ADD_FRIEND_BY_PHONE = 213;
    public static final int SHOW_GROUP_INFO = 214;
    public static final int INIT_ANTI_HARASSMENT_RULE = 215;
    public static final int UPDATE_ANTI_HARASSMENT_RULE = 216;
    public static final int DELETED_ANTI_HARASSMENT_RULE = 217;


    public static final int PUSH_FILE = 218;

    public static final int ADD_TO_DO = 221;
    public static final int ROBOT_LOG = 301;
    public static final int ROBOT_ERROR_LOG = 302;

    public static final int ROBOT_CONTROLLER_TEST = 303;

    public static final int GET_GROUP_INFO = 501;
    public static final int GET_FRIEND_INFO = 502;
    public static final int GET_MY_INFO = 503;
    public static final int GET_GROUP_QRCODE = 504;
    /**
     * type
     * TYPE_HEARTBEAT 心跳检测
     * TYPE_MESSAGE_CONFIRM 消息确认
     * TYPE_MESSAGE_LIST 消息列表
     * SOCKET_TYPE_RAW_CONFIRM 指令消息确认
     */

    public static final int SOCKET_TYPE_HEARTBEAT = 0;
    public static final int SOCKET_TYPE_MESSAGE_CONFIRM = 1;
    public static final int SOCKET_TYPE_MESSAGE_LIST = 2;
    public static final int SOCKET_TYPE_RAW_CONFIRM = 3;


    /**
     * textType
     * <p>
     * 文本类型 TEXT_TYPE_PLAIN
     * 表情类型 同文本类型
     * 群公告类型 同文本类型
     * 图片类型 TEXT_TYPE_IMAGE
     * 语音类型 TEXT_TYPE_VOICE
     * 名片类型 TEXT_TYPE_CARD
     * 视频类型 TEXT_TYPE_VIDEO
     * 定位类型 TEXT_TYPE_LOCATION
     * 小程序类型 TEXT_TYPE_MICROPROGRAM
     * 链接类型 TEXT_TYPE_LINK
     * 文件类型 TEXT_TYPE_FILE
     * 警告类型 TEXT_TYPE_WARNING
     * 群通知类型 TEXT_TYPE_INFO
     * 群接龙类型 TEXT_TYPE_SOLITAIRE
     * 合并聊天记录类型 TEXT_TYPE_CHAT_RECORD
     * 群收集表类型 TEXT_TYPE_COLLECTION
     */
    public static final int TEXT_TYPE = 0;
    public static final int TEXT_TYPE_UNKNOWN = 0;
    public static final int TEXT_TYPE_PLAIN = 1;
    public static final int TEXT_TYPE_IMAGE = 2;
    public static final int TEXT_TYPE_VOICE = 3;
    public static final int TEXT_TYPE_CARD = 4;
    public static final int TEXT_TYPE_VIDEO = 5;
    public static final int TEXT_TYPE_LOCATION = 6;
    public static final int TEXT_TYPE_MICROPROGRAM = 7;
    public static final int TEXT_TYPE_LINK = 8;
    public static final int TEXT_TYPE_FILE = 9;
    public static final int TEXT_TYPE_WARNING = 10;
    public static final int TEXT_TYPE_INFO = 11;
    public static final int TEXT_TYPE_SOLITAIRE = 12;
    public static final int TEXT_TYPE_CHAT_RECORD = 13;
    public static final int TEXT_TYPE_COLLECTION = 14;

    /**
     * 外部群
     */
    public static final int ROM_TYPE_INTER_GROUP =1;
    /**
     * 内部群
     */
    public static final int ROM_TYPE_OUTER_GROUP =2;
    /**
     * 内部联系人
     */
    public static final int ROM_TYPE_INTER_CONTACT =3;
    /**
     * 外部联系人
     */
    public static final int ROM_TYPE_OUTER_CONTACT =4;


}
