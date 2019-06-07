package com.qf.controller;

import com.qf.dto.UserInfoDto;
import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    @RequestMapping(value="insertUserInfo",method = RequestMethod.POST)
    public Object insertUserInfo(@Valid @RequestBody UserInfoDto userInfoDto, BindingResult result, ModelMap modelMap){
        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println(error.getField() + "*" + error.getDefaultMessage());
                modelMap.put("ERR_" + error.getField(), error.getDefaultMessage());
            }
            return modelMap.toString();
        }
        return userInfoService.insertUserInfo(userInfoDto);
    }
    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("deleteUsersInfo")
    public Object deleteUsersInfo(@RequestBody List<Integer>selectUsersId){
        System.out.println(selectUsersId);
        System.out.println(userInfoService.deleteUsersInfo(selectUsersId));
        return userInfoService.deleteUsersInfo(selectUsersId);
    }

    /**
     * 通过Id查询用户
     * @return
     */
    @ResponseBody
    @RequestMapping("getUserInfoById")
    public Object getUserInfoById(@RequestParam int userId){
        return userInfoService.getUserInfoById(userId);
    }

    /**
     * 修改用户信息
     */
    @ResponseBody
    @RequestMapping("updateUserInfoById")
    public Object updateUserInfoById(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfoById(userInfo);
    }
}
