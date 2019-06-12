package com.qf.service.impl;


import com.qf.mapper.CategoryMapper;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    // 查询所有商品类别信息  商品类别列表页面
    public List<CategoryVo> getAllCategory() {
        List<CategoryVo> categoryVoList = categoryMapper.getAllCategory();
        return categoryVoList;
    }

    //    新增商品类别信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addCategoryInfo(Category category) {
        int addCategoryInfo = categoryMapper.addCategoryInfo(category);
        if (addCategoryInfo>0)
            return true;
        return false;
    }

    //    实现商品类别修改功能； 1 先查询展示商品类别详情 2 再 修改商品类别信息
    // 根据商品子类类别id查询商品类别详情信息
    public CategoryVo getCategoryById(int c_id) {
        CategoryVo categoryById = categoryMapper.getCategoryById(c_id);

        return categoryById;
    }

    //修改商品类别信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCategoryInfo(CategoryVo categoryVo) {
        int updateCategoryInfo = categoryMapper.updateCategoryInfo(categoryVo);
        if (updateCategoryInfo>0)
            return true;
        return false;
    }

    //    根据 关键词搜索 商品类别列表
    public List<CategoryVo> selectCategoryBys(String str) {
        List<CategoryVo> categoryVos = categoryMapper.selectCategoryBys("%"+str+"%");
        return categoryVos;
    }

    //根据商品子类类别id 删除商品类别信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delByCid(int childId) {
        int delByCid = categoryMapper.delByCid(childId);
        if (delByCid>0)
            return true;
        return false;
    }

    // 选中删除 ，批量删除
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delCheckCategoryIds(List<Integer> list) {
        int checkCategoryIds = categoryMapper.delCheckCategoryIds(list);
        if (checkCategoryIds==list.size())
            return true;
        return false;
    }

//    查询所有一级类别信息
    public List<Category> getFatherInfo() {
        return categoryMapper.getFatherInfo();
    }
}
