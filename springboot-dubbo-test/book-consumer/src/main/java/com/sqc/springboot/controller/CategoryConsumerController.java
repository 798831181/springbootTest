package com.sqc.springboot.controller;

import com.sqc.springboot.dao.CategoryDao;
import com.sqc.springboot.pojo.Category;
import com.sqc.springboot.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("category")
@Slf4j
public class CategoryConsumerController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("queryall")
    public List<Category> queryAll(){
        return categoryDao.queryAll();
    }
    @GetMapping("list")
    public List<Category> list(){
        log.info("dubbo[] book-consumer[] CategoryConsumerController[] list[] start");
        return categoryService.queryAll();
    }

}
