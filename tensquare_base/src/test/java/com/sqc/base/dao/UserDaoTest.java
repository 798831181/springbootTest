package com.sqc.base.dao;

import com.sqc.base.BaseApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseApplicationTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void listTest(){
        List<User> users = userDao.findAll();
        System.out.println(users);
    }

}