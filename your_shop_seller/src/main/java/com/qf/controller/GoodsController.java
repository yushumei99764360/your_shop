package com.qf.controller;


import com.qf.service.GoodsService;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    // 查询所有商品信息  商品列表页面
    @ResponseBody
    @RequestMapping("getAllGoods")
    public Object getAllGoodsInfo(){
//        System.out.println(2222);
        List<GoodsVo> goodsInfoList = goodsService.getAllGoods();
        System.out.println(goodsInfoList);
        return goodsInfoList;
    }

    // 实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
    @RequestMapping("addGoods")
    public Object addGoods(@RequestBody GoodsVo goodsVo){
        System.out.println(goodsVo);
        boolean addGoods = goodsService.addGoodsInfo(goodsVo);
        System.out.println(addGoods);
        return addGoods;
    }

    //实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    @ResponseBody
    @RequestMapping("getGoodsByGoodsId")
    public Object getGoodsByGoodsId(@RequestParam int goodsId){
        GoodsVo goodsInfoByGoodsId = goodsService.getGoodsInfoByGoodsId(goodsId);
        return goodsInfoByGoodsId;
    }
    @RequestMapping("updateGoodsByGoodsId")
    public Object uodateGoodsInfo(@RequestBody GoodsVo goodsVo) {
        boolean uodateGoodsInfo = goodsService.uodateGoodsInfo(goodsVo);
        return uodateGoodsInfo;
    }

    //    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    @ResponseBody
    @RequestMapping("getGoodsBys")
    public Object getGoodsBys(@RequestBody GoodsSelecteds goodsSelecteds) {
        List<GoodsVo> goodsVos = goodsService.selectGoodsBys(goodsSelecteds);
        return goodsVos;
    }

    //根据商品id 删除商品信息
    @RequestMapping("delByGoodsId")
    public Object delByGoodsId(@RequestParam int goodsId) {
        boolean delByGoodsId = goodsService.delByGoodsId(goodsId);
        return delByGoodsId;
    }


}
