package com.sqc.springboot.controller;

import com.sqc.springboot.domain.User;
import com.sqc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙启超
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET )
    public List<User> getUsers(){
        List<User> users = userService.findAll();
//        modelMap.addAttribute("userList",users);
//        System.out.println("request ok");
//        return "userList";
        return users;
    }
    @PostMapping("/register")
    public String register(){
        return null;
    }
}
