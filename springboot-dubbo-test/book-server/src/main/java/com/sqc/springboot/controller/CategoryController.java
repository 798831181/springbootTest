package com.sqc.springboot.controller;

import com.sqc.springboot.domain.Category;
import com.sqc.springboot.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> findAll(){
        log.info("dubbo[] book-server[] categoryController[] findAll[] starting...");
        List<Category> list = categoryService.findAll();
        log.info("dubbo[] book-server[] categoryController[] findAll[] list:{}",list);
        return list;
    }
}
