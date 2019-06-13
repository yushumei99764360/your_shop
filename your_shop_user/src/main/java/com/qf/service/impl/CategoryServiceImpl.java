package com.qf.service.impl;

import com.qf.dto.CategoryDto;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.Category;
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
    public List<CategoryDto> categoryList() {
        System.out.println(3);
        return categoryMapper.categoryList();
    }


    @Override
    public List<CategoryDto> categoryListOne() {
        return categoryMapper.categoryListOne();
    }

    /**
     * 商品信息查询
     * @param g_id
     * @return
     */
    @Override
    public GoodsInfo getGoodsInfoById(int g_id) {
        return categoryMapper.getGoodsInfoById(g_id);
    }
}
