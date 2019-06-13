package com.qf.service.impl;

import com.qf.dto.Category;
import com.qf.dto.GodsInfoDetail;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.GoodsInfo;
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

    /**
     * 商品信息查询
     * @param g_id
     * @return
     */
    @Override
    public GodsInfoDetail getGoodsInfoById(int g_id) {
        return categoryMapper.getGoodsInfoById(g_id);
    }
}
