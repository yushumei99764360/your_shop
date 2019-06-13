package com.qf.service;


import com.qf.dto.CategoryDto;
import com.qf.dto.GodsInfoDetail;
import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface CategoryService {
    /**
     * 商品分类
     * @return
     */
    public List<CategoryDto> categoryList();


    public List<CategoryDto> categoryListOne();

    GodsInfoDetail getGoodsInfoById(int g_id);
}
