package com.sqc.springboot.controller;

import com.sqc.springboot.domain.User;
import com.sqc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 孙启超
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUsers")
    public String getUsers(ModelMap modelMap){
        List<User> users = userService.findAll();
        modelMap.addAttribute("userList",users);
        return "userList";
    }
    @PostMapping("/register")
    public String register(){
        return null;
    }
}
