package com.qf.service;

import com.qf.pojo.GoodsInfo;

import java.util.List;

public interface GoodsService {

    public List<GoodsInfo> getAllGoods();

    public boolean addGoods(GoodsInfo goodsInfo);

}
