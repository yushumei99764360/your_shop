package com.qf.controller;

import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    // 获取所有商品信息

    @RequestMapping("getAllGoods")
    public Object getAllGoods(){
        System.out.println(2222);
        List<GoodsInfo> goodsInfoList = goodsService.getAllGoods();
        System.out.println(goodsInfoList);
        return goodsInfoList;
    }

    // 新增商品信息
    @RequestMapping("addGoods")
    public Object addGoods(@RequestBody GoodsInfo goodsInfo){
        System.out.println(goodsInfo);
        return goodsService.addGoods(goodsInfo);
    }


}
