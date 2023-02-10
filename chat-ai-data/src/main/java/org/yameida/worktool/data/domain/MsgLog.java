package org.yameida.worktool.data.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息发送记录
 * @TableName msg_log
 */
@TableName(value ="msg_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgLog implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机器人id
     */
    @TableField(value = "robot_id")
    private String robotId;

    /**
     * 消息体
     */
    @TableField(value = "msg")
    private String msg;

    /**
     * 消息响应
     */
    @TableField(value = "response")
    private String response;

    /**
     * 错误码 0 是成功,其他均为错误
     */
    @TableField(value = "error_code")
    private Integer errorCode;

    /**
     * 错误原因
     */
    @TableField(value = "error_reason")
    private String errorReason;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}