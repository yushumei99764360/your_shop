package com.qf.controller;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.MessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.pojo.AddressInfo;
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
import java.io.IOException;
import java.util.List;

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
     * @param userInfoMessageDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public Object updateUserInfo(@RequestBody UserInfoMessageDto userInfoMessageDto, HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        userInfoMessageDto.setUserId(userInfo.getUserId());
        int i = userInfoService.search(userInfo.getUserId());
        if (i!= 0){
            int count = userInfoService.updateUserInfo(userInfoMessageDto);
            if (count > 0) {
                return true;
            }
            return false;
        }else {
           int count = userInfoService.insertUserDetail(userInfoMessageDto);
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
        Integer count = userInfoService.checkUserName(userName);
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
    public Object iconUpload(@RequestParam("file") CommonsMultipartFile file, HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        int userId=userInfo.getUserId();
        String path="D:\\j1901\\第三阶段代码\\your_shop\\your_shop_user\\src\\main\\webapp\\images\\"+file.getOriginalFilename();
        String icon = "images/"+file.getOriginalFilename();
        File newFile=new File(path);
        boolean flag = false;
        try {
            file.transferTo(newFile);
            flag =  userInfoService.updateIconByUserId(userId, icon);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 个人收货地址查询
     */
    @ResponseBody
    @RequestMapping("getUserInfoAddressById")
   public Object getUserInfoAddressById(HttpSession httpSession){
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        return userInfoService.getUserInfoAddressById(userInfo.getUserId());
   }

    /**
     * 收货地址添加
     */
    @ResponseBody
    @RequestMapping("insertUserAddress")
    public Object insertUserAddress(@RequestBody AddressInfoDto addressInfoDto,HttpSession httpSession){
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        addressInfoDto.setUserId(userInfo.getUserId());
        return userInfoService.insertUserAddress(addressInfoDto);
    }
    /**
     * 通过Id删除用户收货地址
     */
    @ResponseBody
    @RequestMapping("deleteAddressById")
    public Object deleteAddressByUserId(@RequestParam int adsId){
        return userInfoService.deleteAddressByUserId(adsId);
    }

//    用户留言查询
    @ResponseBody
    @RequestMapping("selectUserByMessage")
    public Object selectUserByMessage(@RequestParam int g_id){
        List<MessageDto> message   = userInfoService.selectUserByMessage(g_id);
        return message;
    }

//用户评价商品
    @ResponseBody
    @RequestMapping("insertMessageByGoods")
    public Object insertMessageByGoods(@RequestBody MessageDto messageDto,HttpSession httpSession){
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        messageDto.setUserId(userInfo.getUserId());
        int insert = userInfoService.insertMessageByGoods(messageDto);
        return true;
    }

//评价商家图片显示
    @ResponseBody
    @RequestMapping("selectSellPic")
    public Object selectSellPic(@RequestParam int g_id){
        return userInfoService.selectSellPic(g_id);
    }

}
