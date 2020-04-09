package com.xmtx.jobfair.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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

    @Override
    public String toString() {
        return "ReleaseInput{" +
                "eid=" + eid +
                ", promoter_name='" + promoter_name + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
