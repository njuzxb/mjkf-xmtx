package com.xmtx.jobfairComment.enums;

public enum CommentTypeEnum {

    //顶级评论
    PRIMARY_COMMENT(1),
    //二级评论
    SUB_COMMENT(2)
    ;

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
