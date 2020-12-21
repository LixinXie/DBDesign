package com.xie.dbdesign.service.impl;

import com.xie.dbdesign.mapper.UsersMapper;
import com.xie.dbdesign.service.UsersService;

public class UsersServiceImpl implements UsersService {

    UsersMapper usersMapper;

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
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
