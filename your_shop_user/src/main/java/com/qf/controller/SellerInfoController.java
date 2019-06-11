package com.qf.controller;

import com.qf.service.SellerInfosService;
import com.qf.vo.SellerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(aBoolean);
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
}
