package com.sqc.springboot.controller;

import com.sqc.springboot.dao.CategoryDao;
import com.sqc.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("category")
public class CategoryConsumerController {
    @Autowired
    private CategoryDao categoryDao;
    @GetMapping("queryall")
    public List<Category> queryAll(){
        return categoryDao.queryAll();
    }
}
