package com.qf.controller;

import com.qf.pojo.SellerInfo;
import com.qf.service.SellersService;
import com.qf.vo.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SellersController {

    @Autowired
    SellersService sellersService;

    //    店家后台登录
    @RequestMapping("loginSeller")
    public Object loginSeller(@RequestBody SellerVo sellerVo) {
        System.out.println(sellerVo);
        SellerInfo sellerInfo = sellersService.loginSeller(sellerVo);
        if (sellerInfo!=null) {
//        sellerInfo 入域, 并返回true
            return true;
        }
        return false;
    }

    //    根据商家id 查询商家详细信息
    @ResponseBody
    @RequestMapping("getSellerInfoById")
    public Object getSellerInfoById(@RequestParam int s_id) {
        System.out.println(s_id);
        return sellersService.getSellerById(s_id);
    }

    //    修改商家信息
    @RequestMapping("updateSellerInfo")
    public Object updateSellerInfo(@RequestBody SellerVo sellerVo) {
        System.out.println(sellerVo);
        return sellersService.updateSeller(sellerVo);
    }

}
