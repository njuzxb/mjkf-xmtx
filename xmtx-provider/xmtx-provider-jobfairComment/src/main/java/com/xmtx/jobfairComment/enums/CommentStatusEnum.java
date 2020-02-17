package com.xmtx.jobfairComment.enums;

import lombok.Getter;

@Getter
public enum CommentStatusEnum {
    NORMAL(0, "正常"),
    ADMINDETELE(1, "管理删除"),
    ;
    private Integer code;

    private String message;

    CommentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
