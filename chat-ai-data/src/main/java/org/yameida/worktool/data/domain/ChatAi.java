package org.yameida.worktool.data.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * chatGPT机器人
 *
 * @TableName chat_ai
 */
@TableName(value = "chat_ai")
@Data
public class ChatAi implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * chatGpt组织
     */
    @TableField(value = "organization")
    private String organization;

    /**
     * chatGpt密钥
     */
    @TableField(value = "api_key")
    private String apiKey;

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