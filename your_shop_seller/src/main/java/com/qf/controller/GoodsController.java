package com.qf.controller;

import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    // 获取所有商品信息
    @RequestMapping("getAllGoods")
    public Object getAllGoods(){
        return goodsService.getAllGoods();
    }

    // 新增商品信息
    @RequestMapping("addGoods")
    public Object addGoods(@RequestBody GoodsInfo goodsInfo){
        System.out.println(goodsInfo);
        return goodsService.addGoods(goodsInfo);
    }


}
