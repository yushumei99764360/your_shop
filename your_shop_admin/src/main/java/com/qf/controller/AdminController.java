package com.qf.controller;

import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("init")
    public Object adminLogin(){
        return "login";
    }

    /**
     * 管理员登录
     * @param userInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("adminLogin")
    public Object Login(@RequestBody UserInfo userInfo) {
        UserInfo userInfos = userInfoService.adminLogin(userInfo);
        System.out.println();
        if (userInfos!=null){
            return true;
        }
        return  false;
    }
}
