package com.qf.controller;


import com.qf.pojo.Category;
import com.qf.pojo.SellerInfo;
import com.qf.service.CategoryService;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;

    // 查询所有商品信息  商品列表页面
    @ResponseBody
    @RequestMapping("getAllGoods")
    public Object getAllGoodsInfo(HttpSession httpSession){
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        int s_id = sellerInfo.getS_id();
        System.out.println(s_id);
        List<GoodsVo> goodsInfoList = goodsService.getAllGoods(s_id);
        System.out.println(goodsInfoList);
        return goodsInfoList;
    }

    // 实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
    @ResponseBody
    @RequestMapping("addGoodsInfo")
    public Object addGoods(@RequestBody GoodsVo goodsVo,HttpSession httpSession ){

        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        goodsVo.setS_id(sellerInfo.getS_id());
        System.out.println(goodsVo);
        boolean addGoods = goodsService.addGoodsInfo(goodsVo);
        System.out.println(addGoods);
        return addGoods;
    }

    //实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    @ResponseBody
    @RequestMapping("getGoodsByGoodsId")
    public Object getGoodsByGoodsId(@RequestParam int goodsId){
        System.out.println(goodsId);
        GoodsVo goodsInfoByGoodsId = goodsService.getGoodsInfoByGoodsId(goodsId);
        List<Category> categoryList = categoryService.getChildInfo();
        goodsInfoByGoodsId.setCategoryList(categoryList);
        System.out.println(goodsInfoByGoodsId);
        return goodsInfoByGoodsId;
    }
    @ResponseBody
    @RequestMapping("updateGoodsByGoodsId")
    public Object updateGoodsInfo(@RequestBody GoodsVo goodsVo) {
        System.out.println(goodsVo);
        boolean uodateGoodsInfo = goodsService.uodateGoodsInfo(goodsVo);
        System.out.println(uodateGoodsInfo);
        return uodateGoodsInfo;
    }

    //    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    @ResponseBody
    @RequestMapping("getGoodsBys")
    public Object getGoodsBys(@RequestBody GoodsSelecteds goodsSelecteds , HttpSession httpSession) {
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        goodsSelecteds.setSellerId(sellerInfo.getS_id());
        System.out.println(goodsSelecteds);
        List<GoodsVo> goodsVos = goodsService.selectGoodsBys(goodsSelecteds);
        System.out.println(goodsVos);
        return goodsVos;
    }

    //根据商品id 删除商品信息
    @ResponseBody
    @RequestMapping("delByGoodsId")
    public Object delByGoodsId(@RequestParam int goodsId) {
        System.out.println(goodsId);
        boolean delByGoodsId = goodsService.delByGoodsId(goodsId);
        System.out.println(delByGoodsId);
        return delByGoodsId;
    }

    // 删除选中的，批量删除
    @ResponseBody
    @RequestMapping("delCheckGoods")
    public Object delCheckGoods(@RequestBody List<Integer> selectedGoodsId){
        System.out.println(selectedGoodsId);
        boolean delCheckGoods = goodsService.delCheckGoods(selectedGoodsId);
        System.out.println(delCheckGoods);
        return delCheckGoods;
    }


}
