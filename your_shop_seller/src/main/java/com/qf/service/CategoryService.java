package com.qf.service;

import com.qf.pojo.Category;
import com.qf.vo.CategoryVo;

import java.util.List;

public interface CategoryService {

    // 查询所有商品类别信息  商品类别列表页面
    List<CategoryVo> getAllCategory();

    //    新增商品类别信息
    boolean addCategoryInfo(Category category);


    //    实现商品类别修改功能； 1 先查询展示商品类别详情 2 再 修改商品类别信息
    // 根据商品子类类别id查询商品类别详情信息
    CategoryVo getCategoryById(int c_id);
    //修改商品类别信息
    boolean updateCategoryInfo(CategoryVo categoryVo);

    //    根据 关键词搜索 商品类别列表
    List<CategoryVo> selectCategoryBys(String str);

    //根据商品子类类别id 删除商品类别信息
    boolean delByCid(int childId);

    // 选中删除 ，批量删除
    boolean delCheckCategoryIds(List<Integer> list);

    // 查询所有一级类别信息
    List<Category> getFatherInfo();

}
