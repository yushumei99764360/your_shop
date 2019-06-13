package com.qf.controller;

import com.qf.pojo.CartInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.CartInfoService;
import com.qf.vo.CartInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CartInfoController {

    @Autowired
    CartInfoService cartInfoService;

    @RequestMapping(value = "insertIntoCartInfo")
    public Object insertIntoCartInfo(@RequestBody  CartInfoVo cartInfoVo, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        cartInfoVo.setUserId(userInfo.getUserId());
        boolean flag = cartInfoService.insertIntoCartInfo(cartInfoVo);
        return flag;
    }
}
