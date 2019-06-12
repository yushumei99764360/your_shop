package com.qf.mapper;

import com.qf.dto.Category;

import java.util.List;

public interface CategoryMapper {

    /**
     * 商品分类
     * @return
     */
    public List<Category> categoryList();
}
