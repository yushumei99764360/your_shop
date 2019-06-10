package com.qf.controller;

import com.qf.service.UserInfoService2;
import com.qf.tools.CodeUtils;
import com.qf.tools.MailUtils;
import com.qf.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserInfoRegisterController {
    @Autowired
    UserInfoService2 userInfoService2;

    /**
     * 用户注册
     * @param registerUserVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "RegisterUser",method = RequestMethod.POST)
    public String Register(@RequestBody(required = false) RegisterUserVo registerUserVo){
        Boolean aBoolean = userInfoService2.RegisterUserInfo(registerUserVo);
        System.out.println(registerUserVo);
        return aBoolean.toString();
    }

    /**
     * 验证用户名是否已注册
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkUserName",method = RequestMethod.POST)
    public Object checkUserName(@RequestParam String userName){
        System.out.println("用户名为"+userName);
        Integer count = userInfoService2.checkUserName(userName);
        System.out.println("查到的为"+count);
        if(count>=1){
            return false;
        }
        return true;
    }

    /**
     * 邮箱验证码
     * @param email
     * @return
     */
    @RequestMapping(value = "checkEmail",method = RequestMethod.POST)
    public Object checkEmail(@RequestParam String email){
        String code = CodeUtils.getCode();//获取邮箱验证码
        new Thread(new MailUtils(email,code)).start();
        return code;
    }
}
