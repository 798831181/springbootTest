package com.sqc.springboot.service;

import com.sqc.springboot.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
