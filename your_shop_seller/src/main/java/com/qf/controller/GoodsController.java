package com.qf.controller;

import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    // 获取所有商品信息

    @ResponseBody
    @RequestMapping("getAllGoods")
    public Object getAllGoodsInfo(){
//        System.out.println(2222);
        List<GoodsVo> goodsInfoList = goodsService.getAllGoods();
        System.out.println(goodsInfoList);
        return goodsInfoList;
    }

    // 新增商品信息
    @RequestMapping("addGoods")
    public Object addGoods(@RequestBody GoodsVo goodsVo){
        System.out.println(goodsVo);
        boolean addGoods = goodsService.addGoods(goodsVo);
        System.out.println(addGoods);
        return addGoods;
    }


}
