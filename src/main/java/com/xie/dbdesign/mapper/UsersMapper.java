package com.xie.dbdesign.mapper;

public interface UsersMapper {

    // 按用户名查密码
    String queryPswdByUname(String username);

    // 按用户名查用户类型
    String queryTypeByUname(String username);

}
