package com.sqc.springboot.service.impl;

import com.sqc.springboot.domain.User;
import com.sqc.springboot.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User insertByUser(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
