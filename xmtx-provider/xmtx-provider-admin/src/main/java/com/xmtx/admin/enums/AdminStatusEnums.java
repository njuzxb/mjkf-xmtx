package com.xmtx.admin.enums;

import lombok.Getter;
/*
* 管理员权限状态枚举
* */
@Getter
public enum AdminStatusEnums {

    WAIT(0, "无任何权限"),
    FIRST(1, "1级管理员"),
    SECOND(2, "2级管理员"),
    ;

    private Integer code;
    private String message;

    AdminStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
