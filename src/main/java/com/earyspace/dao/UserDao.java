package com.earyspace.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.earyspace.entity.UserInfo;
import com.earyspace.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Date;

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


        // 更新时间
        if (size != 0) {
            UserInfo user = new UserInfo();
            user.setLastLoginTime(new Date());
            userMapper.update(
                    user,
                    wrapper
            );
            return true;
        }

        return false;
    }

    public boolean signup(String email, String nickName, String password) {
        System.out.println("signup::" + email + nickName + password);
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();

        if (userMapper.selectCount(wrapper.eq("email", email)) != 0) {
            return false;
        }

        UserInfo user = new UserInfo();

        user.setEmail(email);
        user.setPassword(password);
        user.setNickName(nickName);
        user.setUserId(email);
        user.setJoinTime(new Date());
        user.setLastLoginTime(new Date());


        return userMapper.insert(user) != 0;
    }
}
