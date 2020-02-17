package com.xmtx.jobfairComment.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    NO_POWER(1, "删除失败，用户无权限"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
