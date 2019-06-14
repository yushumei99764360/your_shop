package com.qf.mapper;


import com.qf.dto.*;
import com.qf.pojo.AddressInfo;
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

    AddressInfoDto searchAddress(int adsId);

    int insertOrder(AddressInfoDto addressInfoDto);

    GodsInfoDetail searchGoods(int g_id);

    int insertOrderDetail(Order_DetailDto order_detailDto);

    Logisticsinfo getlogistics(int g_id);
}
