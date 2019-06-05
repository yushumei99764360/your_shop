package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    @RequestMapping("init")
    public Object adminLogin(){
        return "login";
    }
}
