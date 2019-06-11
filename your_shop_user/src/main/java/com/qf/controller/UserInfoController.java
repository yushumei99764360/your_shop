package com.qf.controller;

import com.qf.dto.UserInfoMessage;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.tools.CodeUtils;
import com.qf.tools.MailUtils;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("init")
    public Object init(){
        return "login";
    }

    /**
     * 登录
     * @param userInfoVo
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userInfoLogin",method = RequestMethod.POST)
    public Object userInfoLogin(@RequestBody UserInfoVo userInfoVo, HttpSession httpSession) {
        UserInfo userInfo = userInfoService.userInfoLogin(userInfoVo);
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
        return userInfoService.getUserInfoMessageById(userInfo.getUserId());
    }

    /**
     * 修改/添加用户详细信息
     * @param userInfoMessage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public Object updateUserInfo(@RequestBody UserInfoMessage userInfoMessage,HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        userInfoMessage.setUserId(userInfo.getUserId());
        int i = userInfoService.search(userInfo.getUserId());
        if (i!= 0){
            int count = userInfoService.updateUserInfo(userInfoMessage);
            if (count > 0) {
                return true;
            }
            return false;
        }else {
           int count = userInfoService.insertUserDetail(userInfoMessage);
            if (count > 0) {
                return true;
            }
            return false;
        }

    }


    /**
     * 用户注册
     * @param userInfoVo 用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "RegisterUser",method = RequestMethod.POST)
    public String Register(@RequestBody(required = false) UserInfoVo userInfoVo){
        Boolean aBoolean = userInfoService.RegisterUserInfo(userInfoVo);
        System.out.println(userInfoVo);
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
        Integer count = userInfoService.checkUserName(userName);
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

    /**
     * 退出
     */
    @RequestMapping("exit")
    public Object exit(HttpSession httpSession){
        httpSession.removeAttribute("userInfo");
        httpSession.invalidate();
        return "login";
    }

    /**
     * 修改个人头像
     */
    @RequestMapping(value = "upDownload", method = RequestMethod.POST)
    public Object  iconUpload(@RequestParam("file") CommonsMultipartFile file,HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        int userId = userInfo.getUserId();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:\\j1901\\第三阶段代码\\your_shop\\your_shop_user\\src\\main\\webapp\\images";
        String icon = "images/"+file.getOriginalFilename();
        File newFile=new File(path);
        boolean flag = false;
        try {
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            file.transferTo(newFile);
            flag =  userInfoService.updateIconByUserId(userId, icon);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
