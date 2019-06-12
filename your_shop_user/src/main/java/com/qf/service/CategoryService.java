package com.qf.service;

import com.qf.dto.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 商品分类
     * @return
     */
    public List<Category> categoryList();
}
