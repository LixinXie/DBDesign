package com.xie.dbdesign.service;

import com.xie.dbdesign.entity.Users;

import java.util.List;

public interface UsersService {

    // 增加用户
    int addUser(Users user);

    // 修改用户
    int updateUser(Users user);

    // 按用户名删除用户
    int deleteUserByUsername(String username);

    // 按用户名查询用户信息
    Users queryUserByUsername(String username);

    // 查询所有用户信息
    List<Users> queryAllUser();

    // 按用户名查密码
    String queryPswdByUname(String username);

    // 按用户名查用户类型
    String queryTypeByUname(String username);
}
