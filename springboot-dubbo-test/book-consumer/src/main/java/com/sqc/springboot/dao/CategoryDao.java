package com.sqc.springboot.dao;

import com.sqc.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryDao {
    @Autowired
    private RestTemplate restTemplate;
    public List<Category> queryAll() {
        String url = "http://127.0.0.1:8084/category/findAll";
        Category[] categories = restTemplate.getForObject(url, Category[].class);
        List<Category> categoryList = Arrays.asList(categories);
        return categoryList;
    }

}
