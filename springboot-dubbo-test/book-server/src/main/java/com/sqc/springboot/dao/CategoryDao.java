package com.sqc.springboot.dao;

import com.sqc.springboot.domain.Category;

import java.util.List;
/**
 * @author 孙启超
 */
public interface CategoryDao {
    List<Category> findAll();
}
