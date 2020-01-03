package com.xmtx.provider.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)    //链式写法
@Entity
public class Admin implements Serializable {    //admin实体类

    @Id
    @GeneratedValue
    private Integer id; //主键

    private String username;

    private String password;

    private String salt;

    private String name;

    private Integer enabled;

    private String db_source;


    public Admin(String username, String password, String salt, String name, int enabled) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.enabled = enabled;
    }
}
