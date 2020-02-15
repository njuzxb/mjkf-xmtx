package com.xmtx.jobfair.enums;

import lombok.Getter;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 22:43 2020/2/13
 * @ Description：招聘会状态枚举类
 * @ Modified By：
 * @Version: $
 */
@Getter
public enum JobFairStatusEnum {//针对Enable字段返回值
    DISABLE(0,"该公司无权发布招聘会"),
    ENABLE(1,"该公司有发布招聘会资格");

    private Integer code;
    private String msg;
    JobFairStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
