package com.qf.controller;

import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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


    /**
     * 会员删除
     */
    @ResponseBody
    @RequestMapping("deleteUserInfoById")
    public Object deleteUserInfoById(@RequestParam int userId){
        return userInfoService.deleteUserInfoById(userId);
    }

    /**
     * 分页
     */
    @ResponseBody
    @RequestMapping(value = "pageUsers",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request){
        Map<String,Object> result = new HashMap<String, Object>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");
        int draw =strdraw==null?0:Integer.parseInt(strdraw);
        int start =strdraw==null?0:Integer.parseInt(strstart);
        int length =strdraw==null?10:Integer.parseInt(strlength);
        result.put("draw",draw);
        result.put("recordsTotal",userInfoService.count());
        result.put("recordsFiltered",userInfoService.count());
        result.put("data",userInfoService.page(start,length));
        result.put("error","");
        return result;
    }

    /**
     * 添加会员
     */
    @ResponseBody
    @RequestMapping("insertUserInfo")
    public Object insertUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.insertUserInfo(userInfo);
    }
}
