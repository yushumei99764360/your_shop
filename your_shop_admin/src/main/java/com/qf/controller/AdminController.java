package com.qf.controller;

import com.qf.pojo.AdminInfo;
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
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("adminLogin")
        public Object Login(@RequestBody AdminInfo adminInfo) {
        AdminInfo adminInfos = userInfoService.adminLogin(adminInfo);
        System.out.println();
        if (adminInfos!=null){
            return true;
        }
        return  false;
    }


    /**
     * 会员查询
     */

    @ResponseBody
    @RequestMapping("listAllUserInfo")
    public Object listAllUserInfo(){
        return userInfoService.listAllUserInfo();
    }
}
