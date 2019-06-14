package com.qf.controller;

import com.qf.pojo.SellerInfo;
import com.qf.service.SellersService;
import com.qf.vo.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

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


    // 修改商家头像
    @RequestMapping(value = "iconUploadCode", method = RequestMethod.POST)
    public Object  iconUploadCode(@RequestParam("file") CommonsMultipartFile file, @RequestParam("s_code") String s_code) {

        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:\\Java1901\\your_shop\\your_shop_seller\\src\\main\\webapp\\images"+file.getOriginalFilename();

        String icon = "images/"+file.getOriginalFilename();
        File newFile=new File(path);
        boolean flag = false;
        try {
            file.transferTo(newFile);
            flag =  sellersService.updatePicBySellerId(s_code, icon);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
