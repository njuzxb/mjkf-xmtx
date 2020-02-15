package com.xmtx.jobfair.enums;

import lombok.Getter;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 23:01 2020/2/13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Getter
public enum ResultEnum {
    JOBFAIR_NOT_EXIST(1,"该公司不存在"),
    PARAM_ERROR(2,"参数错误");

    private Integer code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
