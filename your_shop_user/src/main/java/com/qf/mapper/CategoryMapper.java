package com.qf.mapper;


import com.qf.dto.*;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.vo.CategoryVo;

import java.util.List;

public interface CategoryMapper {

    public List<GoodsInfo> getAllGoods();

    GodsInfoDetail getGoodsInfoById(int g_id);

    AddressInfoDto searchAddress(int adsId);

    int insertOrder(AddressInfoDto addressInfoDto);

    GodsInfoDetail searchGoods(int g_id);

    int insertOrderDetail(Order_DetailDto order_detailDto);


    Logisticsinfo getlogistics(int g_id);
}
