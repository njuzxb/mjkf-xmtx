package com.xmtx.jobfairComment.enums;

import lombok.Getter;

@Getter
public enum CommentErrorCode {

    SUBCOMMENT_NOT_EXIST(1000, "该二级评论不存在"),
    UNAUTHORIZED_DELETE(1001, "当前用户无删除评论的权限"),
    TARGET_PARAM_NOT_FOUND(1002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(1003, "当前操作需要登录，请登陆后重试"),
    TYPE_PARAM_WRONG(1004, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(1005, "回复的评论不存在了，要不要换个试试？"),
    CONTENT_IS_EMPTY(1006, "输入内容不能为空")
    ;

    Integer code;
    String message;

    CommentErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
