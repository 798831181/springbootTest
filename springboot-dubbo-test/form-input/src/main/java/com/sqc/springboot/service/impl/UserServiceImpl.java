package com.sqc.springboot.service.impl;

import com.sqc.springboot.domain.User;
import com.sqc.springboot.domain.UserRepository;
import com.sqc.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author 孙启超
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User insertByUser(User user) {
        log.info("springboot-dubbo-test[]springboot-dubbo-server[]UserService[] insertByUser[]user:{} ",user);
        System.out.println(user);
        return userRepository.save(user);
    }
}
