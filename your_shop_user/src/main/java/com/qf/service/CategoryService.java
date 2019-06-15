package com.qf.service;


import com.qf.dto.*;
import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface CategoryService {

    public List<GoodsInfo> getSonCategory();

    GodsInfoDetail getGoodsInfoById(int g_id);

    AddressInfoDto searchAddress(int adsId);

    int insertOrder(AddressInfoDto addressInfoDto);

    int insertOrderDetail( Order_DetailDto order_detailDto);

    GodsInfoDetail searchGoods(int g_id);

    Logisticsinfo getlogistics(int g_id);
}
