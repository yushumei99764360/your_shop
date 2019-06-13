package com.qf.service.impl;

import com.qf.dto.GodsInfoDetail;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    //    查询所有一级类别信息
    public List<Category> getFatherInfo() {
        return categoryMapper.getFatherInfo();
    }

    //    查询所有二级类别信息
    public List<Category> getChildInfo() {
        return categoryMapper.getChildInfo();
    }

    // 根据父类id 查询它所包含的所有子类信息
    public CategoryVo getChildCategoryInfo(int fatherId) {
        CategoryVo categoryVo = categoryMapper.getChildCategoryInfo(fatherId);
        return categoryVo;
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
