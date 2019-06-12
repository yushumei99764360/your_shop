package com.qf.service.impl;

import com.qf.dto.Category;
import com.qf.mapper.CategoryMapper;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> categoryList() {
        return categoryMapper.categoryList();
    }
}
