package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.entity.Users;
import com.xie.dbdesign.mapper.UsersMapper;
import com.xie.dbdesign.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    UsersMapper usersMapper;

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public int addUser(Users user) {
        return usersMapper.addUser(user);
    }

    @Override
    public int updateUser(Users user) {
        return usersMapper.updateUser(user);
    }

    @Override
    public int deleteUserByUsername(String username) {
        return usersMapper.deleteUserByUsername(username);
    }

    @Override
    public Users queryUserByUsername(String username) {
        return usersMapper.queryUserByUsername(username);
    }

    @Override
    public List<Users> queryAllUser() {
        return usersMapper.queryAllUser();
    }

    @Override
    public String queryPswdByUname(String username) {
        return usersMapper.queryPswdByUname(username);
    }

    @Override
    public String queryTypeByUname(String username) {
        return usersMapper.queryTypeByUname(username);
    }
}
