package com.xmtx.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private String loginName;

    private String loginPswd;

    private String userName;

    private String userPhone;

    private String userEmail;
//    验证码
//    private String randomCode;


}
