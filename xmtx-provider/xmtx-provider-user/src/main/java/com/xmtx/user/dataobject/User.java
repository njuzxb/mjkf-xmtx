package com.xmtx.user.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键
    /*用户账号*/
    private String username;
    /*用户密码*/
    private String password;
    /*盐加密*/
    private String salt;
    /*姓名*/
    private String name;
    /*电话*/
    private String phone;
    /*邮箱*/
    private String email;
    /*创建时间*/
    private Date gmt_create;
    /*修改时间*/
    private Date gmt_modified;
    /*关联企业id*/
    private Integer eid;
    /*是否企业用户*/
    private Integer is_enterprise;
    /*审核*/
    private Integer enabled;


}
