package com.qf.controller;

import com.qf.pojo.SellerInfo;
import com.qf.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @RequestMapping(value = "listAllSellerInfo", method = RequestMethod.POST)
    public Object listAllSellerInfo() {
        List<SellerInfo> sellerInfos = sellerService.listAllSellerInfo();
        System.out.println(sellerInfos);
        return sellerInfos;
    }

    /**
     * 分页
     */

    @RequestMapping(value = "pageSellers",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request){

        Map<String,Object> result = new HashMap<String, Object>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");
        int draw =strdraw==null?0:Integer.parseInt(strdraw);
        int start =strdraw==null?0:Integer.parseInt(strstart);
        int length =strdraw==null?10:Integer.parseInt(strlength);
        result.put("draw",draw);
        result.put("recordsTotal",sellerService.count());
        result.put("recordsFiltered",sellerService.count());
        result.put("data",sellerService.page(start,length));
        result.put("error","");
        return result;
    }
}
