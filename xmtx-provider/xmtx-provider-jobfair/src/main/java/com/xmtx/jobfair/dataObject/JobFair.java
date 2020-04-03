package com.xmtx.jobfair.dataObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:34 2020/2/13
 * @ Description：招聘会实体类
 * @ Modified By：
 * @Version: $
 */
@Data
@Entity
public class JobFair implements Serializable {
    @Id
    private Integer id;
    /**  公司ID **/
    private Integer eid;
    /**  发起人 **/
    private String promoter;
    /**  招聘会时间 **/
    private Date meetingTime;
    /**  招聘会地址 **/
    private String address;
    /**  标题 **/
    private String title;
    /**  标签 **/
    private String label;
    /**  是否拥有举办招聘会资格 **/
    private Integer enabled;
    /**  所属数据库 **/
    private Integer dbSource;
    /**  招聘会内容 **/
    private String content;
}
