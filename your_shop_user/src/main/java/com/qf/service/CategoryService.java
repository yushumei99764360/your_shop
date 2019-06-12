package com.qf.service;

import com.qf.dto.Category;
import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface CategoryService {
    /**
     * 商品分类
     * @return
     */
    public List<Category> categoryList();

    GoodsInfo getGoodsInfoById(int g_id);
}
