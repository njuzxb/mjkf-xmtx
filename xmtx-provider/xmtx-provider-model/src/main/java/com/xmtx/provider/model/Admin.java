package com.xmtx.provider.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)    //链式写法
public class Admin implements Serializable {    //admin实体类

    private int id; //主键
    private String username;
    private String password;
    private String salt;
    private String name;
    private int enable;
    private String db_source;

    public Admin(String username, String password, String salt, String name, int enable) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.enable = enable;
    }
}
