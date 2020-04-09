package com.xmtx.jobfair.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 12:53 2020/2/15
 * @ Description：招聘会发布提交表单
 * @ Modified By：
 * @Version: $
 */
@Data
public class JobFairForm_Release implements Serializable {
    @NotNull(message = "企业id必填")
    private Integer eid;

    @NotEmpty(message = "发起人姓名必填")
    private String promoter_name;

    @NotEmpty(message = "标题必填")
    private String title;

    @NotEmpty(message = "标签必填")
    private String label;

    @NotEmpty(message = "详情必填")
    private String content;

    @NotEmpty(message = "地址必填")
    private String address;

}
