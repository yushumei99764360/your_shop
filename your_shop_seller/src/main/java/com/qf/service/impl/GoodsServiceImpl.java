package com.qf.service.impl;

import com.qf.mapper.GoodsMapper;
import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<GoodsVo> getAllGoods() {
        return goodsMapper.getAllGoods();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addGoods(GoodsVo goodsVo) {
        int addGoods = goodsMapper.addGoodsInfo(goodsVo);
        int addGoodsCategory = goodsMapper.addGoodsCategory(goodsVo);


        if (addGoods>0 && addGoodsCategory >0){
            return true;
        }
        return false;
    }



}
