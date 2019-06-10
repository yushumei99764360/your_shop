package com.qf.controller;

import com.qf.dto.UserInfoMessage;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("init")
    public Object init(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "userInfoLogin",method = RequestMethod.POST)
    public Object userInfoLogin(@RequestBody UserInfoLoginVo userInfoLoginVo, HttpSession httpSession) {
        UserInfo userInfo = userInfoService.userInfoLogin(userInfoLoginVo);
        if (userInfo != null) {
            httpSession.setAttribute("userInfo",userInfo);
            return true;
        }
        return false;
    }

    /**
     *通过Id查询用户详细信息
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUserInfoMessageById",method = RequestMethod.GET)
    public Object getUserInfoMessageById(HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        
        System.out.println(userInfo.getUserId());
        UserInfoMessage userInfoMessageById = userInfoService.getUserInfoMessageById(userInfo.getUserId());
        System.out.println(userInfoMessageById);
        return userInfoMessageById;
    }
}
