package com.qf.controller;

import com.qf.pojo.AdminInfo;
import com.qf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminSelfController {
    @Autowired
    AdminInfoService adminInfoService;

    /**
     * 管理员添加
     * @param adminInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("insertAdminInfo")
    public Object insertAdminInfo(@RequestBody AdminInfo adminInfo){
        return adminInfoService.insertAdminInfo(adminInfo);
    }


    /**
     * 管理员列表分页
     */

    @ResponseBody
    @RequestMapping(value = "pageAdmins",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request){
        Map<String,Object> result = new HashMap<String, Object>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");
        int draw =strdraw==null?0:Integer.parseInt(strdraw);
        int start =strdraw==null?0:Integer.parseInt(strstart);
        int length =strdraw==null?10:Integer.parseInt(strlength);
        result.put("draw",draw);
        result.put("recordsTotal",adminInfoService.count());
        result.put("recordsFiltered",adminInfoService.count());
        result.put("data",adminInfoService.page(start,length));
        result.put("error","");
        return result;
    }

    /**
     * 通过Id删除管理员
     */
    @ResponseBody
    @RequestMapping("deleteAdminInfoById")
    public Object deleteAdminInfoById(@RequestParam int aid){
        return adminInfoService.deleteAdminInfoById(aid);
    }
    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("deleteAdminInfo")
    public Object deleteAdminInfo(@RequestBody List<Integer> selectAdminId){
        return adminInfoService.deleteAdminInfo(selectAdminId);
    }
    /**
     * 通过Id查询管理员
     * @return
     */
    @ResponseBody
    @RequestMapping("getAdminInfoById")
    public Object getAdminInfoById(@RequestParam int aid){
        return adminInfoService.getAdminInfoById(aid);
    }
    /**
     * 通过Id修改管理员
     */
    @ResponseBody
    @RequestMapping("updateAdminInfoById")
    public Object updateAdminInfoById(@RequestBody AdminInfo adminInfo){
        return adminInfoService.updateAdminInfoById(adminInfo);
    }
    /**
     * 查询用户名是否存在
     */
    @ResponseBody
    @RequestMapping("checkAdminName")
    public Object checkAdminName(@RequestParam String username){
        int i = adminInfoService.checkAdminName(username);
        if (i==1){
            return false;
        }else {
            return true;
        }
    };
}
