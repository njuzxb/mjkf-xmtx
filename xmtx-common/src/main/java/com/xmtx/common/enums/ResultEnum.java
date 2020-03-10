package com.xmtx.common.enums;

import lombok.Getter;


@Getter
public enum ResultEnum {
    Success(0, "成功"),
    Fail(1, "失败"),
    MESSAGE_REDIS_KEY_OR_VALUE_INVALID(3,"待存入Redis的key或value不是有效字符串！"),
    MESSAGE_REDIS_KEY_TIME_OUT_INVALID(4,"抱歉！不接受0或null值，请明确表达您的意图：是否设置过期时间。"),
    USER_NOT_EXIST(21, "用户不存在"),
    PSW_ERROR(22,"密码错误"),
    ROLE_ERROR(23, "角色权限有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
