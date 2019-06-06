package com.qf.service;

import com.qf.pojo.GoodsInfo;
import com.qf.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    public List<GoodsVo> getAllGoods();

    public boolean addGoods(GoodsVo goodsVo);

}
