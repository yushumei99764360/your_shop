package com.qf.controller;

import com.qf.pojo.SellerInfo;
import com.qf.service.SellersService;
import com.qf.vo.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class SellersController {

    @Autowired
    SellersService sellersService;

    //    店家后台登录
    @RequestMapping("loginSeller")
    public Object loginSeller(@RequestBody SellerVo sellerVo, HttpSession httpSession) {
        System.out.println(sellerVo);
        SellerInfo sellerInfo = sellersService.loginSeller(sellerVo);
        if (sellerInfo!=null) {
//        sellerInfo 入域, 并返回true
            httpSession.setAttribute("sellerInfo",sellerInfo);
            return true;
        }
        return false;
    }

    //    根据商家登录时的信息 查询商家详细信息
    @RequestMapping("getSellerInfoById")
    public Object getSellerInfoById(HttpSession httpSession) {
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        SellerInfo sellerById = sellersService.getSellerById(sellerInfo.getS_id());
        System.out.println(sellerById);
        return sellerById;
    }

    //    修改商家信息
    @RequestMapping("updateSellerInfo")
    public Object updateSellerInfo(@RequestBody SellerVo sellerVo) {
        System.out.println(sellerVo);
        boolean updateSeller = sellersService.updateSeller(sellerVo);
        System.out.println(updateSeller);
        return updateSeller;
    }

}
