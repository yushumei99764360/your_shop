package com.qf.mapper;


import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface GoodsMapper {

    List<GoodsInfo> getAllGoods();

    int addGoods(GoodsInfo goodsInfo);

}
