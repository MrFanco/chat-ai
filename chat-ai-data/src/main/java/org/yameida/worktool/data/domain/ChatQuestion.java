package org.yameida.worktool.data.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 被询问消息记录
 * @TableName chat_question
 */
@TableName(value ="chat_question")
@Data
public class ChatQuestion implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机器人id
     */
    @TableField(value = "robot_id")
    private String robotId;

    /**
     * 问题文本
     */
    @TableField(value = "spoken")
    private String spoken;

    /**
     * 原始问题文本
     */
    @TableField(value = "raw_spoken")
    private String rawSpoken;

    /**
     * 提问者名称
     */
    @TableField(value = "received_name")
    private String receivedName;

    /**
     * QA所在群名（群聊）
     */
    @TableField(value = "group_name")
    private String groupName;

    /**
     * QA所在群备注名（群聊）
     */
    @TableField(value = "group_remark")
    private String groupRemark;

    /**
     * QA所在房间类型 1=外部群 2=外部联系人 3=内部群 4=内部联系人
     */
    @TableField(value = "room_type")
    private Integer roomType;

    /**
     * 是否@机器人（群聊）
     */
    @TableField(value = "at_me")
    private Integer atMe;

    /**
     * 回复的ai主键id
     */
    @TableField(value = "ai_id")
    private Integer aiId;

    /**
     * ai回复的答案
     */
    @TableField(value = "answer")
    private String answer;

    /**
     * 耗时
     */
    @TableField(value = "cost_time")
    private Integer costTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill =FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField(value = "del")
    @TableLogic(delval = "1", value = "0")
    private Integer del;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}