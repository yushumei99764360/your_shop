package com.qf.controller;

import com.qf.pojo.GoodsInfo;
import com.qf.pojo.SellerInfo;
import com.qf.service.SellerInfosService;
import com.qf.vo.SellerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SellerInfoController {
    @Autowired
    SellerInfosService sellerInfosService;

    /**
     * 商家信息注册
     * @param sellerInfoVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "RegisterSeller",method = RequestMethod.POST)
    public String RegisterSeller(@RequestBody(required = false)SellerInfoVo sellerInfoVo){
        Boolean aBoolean = sellerInfosService.RegisterSellerInfo(sellerInfoVo);
        return aBoolean.toString();
    }

    /**
     * 判断商家名称是否存在
     * @param s_name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkSellerName",method = RequestMethod.POST)
    public Object CheckSellerName(@RequestParam String s_name){
        Integer count = sellerInfosService.checkSellerName(s_name);
        if(count>=1){
            return false;
        }
        return true;
    }

    /**
     * 根据商家ID找出所有商品信息
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "GoodsInfoById",method = RequestMethod.POST)
    public Object GoodsInfoBySellerID(@RequestParam Integer s_id){
        List<GoodsInfo> goodsInfos = sellerInfosService.SelectGoodsBySellerID(s_id);
        for (GoodsInfo goodsInfo: goodsInfos) {
            System.out.println(goodsInfo);
        }
        return goodsInfos;
    }
    /**
     * 根据商家ID找出对应商家信息
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectSeller",method = RequestMethod.POST)
    public Object SelectSellerById(@RequestParam Integer s_id){
        System.out.println(s_id);
        List<SellerInfo> sellerInfos = sellerInfosService.SelectSeller(s_id);
        for (SellerInfo sellerInfo: sellerInfos) {
            System.out.println(sellerInfo);
        }
        return sellerInfos;
    }
}
