package com.xmtx.jobfair.dataObject;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:20 2020/2/13
 * @ Description：企业实体类
 * @ Modified By：
 * @Version: $
 */
@Data
@Entity
public class EnterpriseInfo {
    @Id
    //@GeneratedValue
    private Integer id;
    /**  公司名字 **/
    private String enterpriseName;
    /**  公司logo **/
    private String logo;
    /**  公司简介 **/
    private String description;
    /**  公司官网**/
    private String website;
    /**  公司地址 **/
    private String address;
    /**  发布资格 **/
    private boolean enabled;

}
