package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class UserController {

    @Resource
    UserService userService;

    @Value("${test.zzy}")
    String test;

    @RequestMapping("user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        System.out.println("Hello,user-service");
        System.out.println(test);
        return userService.getUserById(uid);
    }

    @RequestMapping("/user/remain/{uid}")
    public int userRemain(@PathVariable("uid") int uid){
        return userService.getRemain(uid);
    }

    @RequestMapping("/user/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid") int uid){
        int remain = userService.getRemain(uid);
        return userService.setRemain(uid, remain - 1);
    }
}
