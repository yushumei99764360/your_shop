package com.qf.controller;

import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;


    @RequestMapping(value = "userInfoLogin",method = RequestMethod.POST)
    public Object userInfoLogin(@RequestBody UserInfoLoginVo userInfoLoginVo) {
        if (userInfoService.userInfoLogin(userInfoLoginVo)) {
            return true;
        }
        return false;
    }
}
