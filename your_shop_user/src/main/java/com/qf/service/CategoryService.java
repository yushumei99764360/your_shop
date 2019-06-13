package com.qf.service;


import com.qf.dto.CategoryDto;
import com.qf.dto.GodsInfoDetail;
import com.qf.pojo.Category;
import com.qf.vo.CategoryVo;

import java.util.List;

public interface CategoryService {

    // 查询所有一级类别信息
    List<Category> getFatherInfo();

    //    查询所有的二级类别信息
    List<Category> getChildInfo();

    // 根据父类id 查询它所包含的所有子类信息
    CategoryVo getChildCategoryInfo(int fatherId);

    GodsInfoDetail getGoodsInfoById(int g_id);
}
