package com.xmtx.jobfair.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 21:00 2020/2/16
 * @ Description：更新招聘会表单
 * @ Modified By：
 * @Version: $
 */
@Data
public class JobFairForm_Update {
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
