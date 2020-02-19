package com.xmtx.jobfair.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 0:07 2020/2/19
 * @ Description：update传入参数
 * @ Modified By：
 * @Version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInput {
    @NotNull(message = "宣讲会id必填")
    private Integer id;

    @NotEmpty(message = "标题必填")
    private String title;

    @NotEmpty(message = "标签必填")
    private String label;

    @NotEmpty(message = "详情必填")
    private String content;

    @NotEmpty(message = "地址必填")
    private String address;
}
