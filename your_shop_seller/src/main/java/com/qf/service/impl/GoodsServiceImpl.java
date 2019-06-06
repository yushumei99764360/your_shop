package com.qf.service.impl;

import com.qf.mapper.GoodsMapper;
import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<GoodsInfo> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addGoods(GoodsInfo goodsInfo) {
        int addGoods = goodsMapper.addGoods(goodsInfo);

        if (addGoods>0){
            return true;
        }
        return false;
    }



}
