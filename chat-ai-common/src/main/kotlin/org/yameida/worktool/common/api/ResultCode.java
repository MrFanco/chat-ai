package org.yameida.worktool.common.api;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    ROBOT_OFFLINE(501, "机器人不在线"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "未登录或登录已过期，请重新登录~"),
    FORBIDDEN(403, "没有相关权限"),
    NOINFORMATIONCABINET(10001,"无此机柜信息");

    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
