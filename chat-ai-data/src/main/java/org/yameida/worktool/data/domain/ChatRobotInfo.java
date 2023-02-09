package org.yameida.worktool.data.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName chat_robot_info
 */
@TableName(value = "chat_robot_info")
@Data
public class ChatRobotInfo implements Serializable {
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
     * 机器人校验key
     */
    @TableField(value = "robot_key")
    private String robotKey;

    /**
     * 企业名称
     */
    @TableField(value = "corporation")
    private String corporation;

    /**
     * 机器人昵称
     */
    @TableField(value = "nick")
    private String nick;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
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