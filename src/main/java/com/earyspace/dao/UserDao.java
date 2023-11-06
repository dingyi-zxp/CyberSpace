package com.earyspace.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.earyspace.entity.UserInfo;
import com.earyspace.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserDao {


    @Resource
    UserMapper userMapper;


    public boolean checkLogin(String account, String password) {

        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();

        wrapper
                .eq("user_id", account)
                .eq("password", password);

        int size = userMapper.selectList(wrapper).size();


        return size != 0;
    }
}
