package com.qf.controller;

import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @ResponseBody
    @RequestMapping("adminLogin")
    public Object Login() {
    return "";
    }
}
