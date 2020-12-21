package com.xie.dbdesign.entity;

import lombok.Data;

@Data
public class Users {

    // 用户名
    private String username;
    // 密码
    private String pswd;
    // 用户类型
    private String usertype;

}
