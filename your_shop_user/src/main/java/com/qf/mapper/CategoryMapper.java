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
    public List<Category> categoryList();

    GodsInfoDetail getGoodsInfoById(int g_id);
}
