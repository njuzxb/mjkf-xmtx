package com.xmtx.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 0:08 2020/2/15
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
