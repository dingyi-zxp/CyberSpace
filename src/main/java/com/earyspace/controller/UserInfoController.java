package com.earyspace.controller;


import com.earyspace.dao.UserDao;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@Log
@RestController
@RequestMapping("/user_info")
public class UserInfoController {

    @Resource
    UserDao userDao;

    @GetMapping("/get_all_user")
    public void getAllUserInfo() {
    }

    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    public void checkLogin(@Param("account") String account, @Param("password") String password,
                           HttpServletResponse response) throws IOException {


        System.out.println(account + password);
        boolean status = userDao.checkLogin(account, password);
        log.info(account + password);
        PrintWriter writer = response.getWriter();
        if (status) {
            writer.write("200");
        } else {
            writer.write("403");
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signupAccount(@Param("email") String email,@Param("nickName") String nickName, @Param("password") String password,
                              HttpServletResponse response) throws IOException {

        System.out.println("email ::" +  email);

        PrintWriter writer = response.getWriter();
        boolean status = userDao.signup(email,nickName,password);
        if (status){
            writer.write("200");
        }else {
            writer.write("403");
        }

    }
}
