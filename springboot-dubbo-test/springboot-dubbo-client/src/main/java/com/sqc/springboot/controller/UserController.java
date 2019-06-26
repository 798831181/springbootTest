package com.sqc.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqc.springboot.domain.User;
import com.sqc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
/*    @Autowired
    UserService userService;
    public String getUsers(){
        List<User> userList = userService.findAll();
        return userList.toString();
    }*/
@RequestMapping("testHello")
    public String testHello() {
        return "Hello";
    }

}
