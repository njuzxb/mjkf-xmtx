package com.xmtx.jobfairComment.exception;

import com.xmtx.jobfairComment.enums.CommentErrorCode;

public class CommentException extends RuntimeException {

    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public CommentException(CommentErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
    }

}
