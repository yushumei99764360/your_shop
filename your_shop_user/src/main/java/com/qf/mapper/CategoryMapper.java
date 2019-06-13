package com.qf.mapper;

import com.qf.dto.Category;
import com.qf.dto.GodsInfoDetail;
import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface CategoryMapper {

    /**
     * 商品分类
     * @return
     */
    public List<CategoryDto> categoryList();

    public List<CategoryDto> categoryListOne();

    GodsInfoDetail getGoodsInfoById(int g_id);
}
