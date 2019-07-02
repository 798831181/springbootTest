package com.sqc.springboot.controller;

import com.sqc.springboot.domain.User;
import com.sqc.springboot.domain.UserRepository;
import com.sqc.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 孙启超
 */
@Slf4j
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET )
    public String  getUsers(ModelMap modelMap){
        List<User> users = userService.findAll();
        modelMap.addAttribute("userList",users);
        return "userList";
    }
    @GetMapping("/create")
    public String createUser(ModelMap map){
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return "userForm";
    }
    @PostMapping("create")
    public String postUser(ModelMap map,
                           @ModelAttribute @Valid User user,
                           BindingResult bindingResult) {
//        System.out.println("springboot-dubbo-test[]server[]UserController[]postUser[] post starting");
        log.info("springboot-dubbo-test[]server[]UserController[]postUser[] post starting");
        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }
        log.info("springboot-dubbo-test[]server[]UserController[]postUser[] user{}" + user);
        userService.insertByUser(user);
//        System.out.println("springboot-dubbo-test[]server[]UserController[]postUser[] success");
        log.info("springboot-dubbo-test[]server[]UserController[]postUser[] success");
//        Logger.info("springboot-dubbo-test[]server[]UserController[]postUser[] success");
        return "redirect:/users/getUsers";
    }
    @PostMapping("/register")
    public String register(){
        return null;
    }
}
