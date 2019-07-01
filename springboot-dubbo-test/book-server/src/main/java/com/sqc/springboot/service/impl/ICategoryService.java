package com.sqc.springboot.service.impl;

import com.sqc.springboot.dao.CategoryDao;
import com.sqc.springboot.domain.Category;
import com.sqc.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ICategoryService implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
