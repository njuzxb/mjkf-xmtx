package com.xmtx.jobfair.common;

import lombok.Data;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 0:08 2020/2/15
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class ResultVO<T> {
    /*
     *   错误码正常返回为0
     * */
    private Integer code;
    /*
     *   提示信息
     * */
    private String msg;
    /*
     *   具体内容
     * */
    private T data;
}
