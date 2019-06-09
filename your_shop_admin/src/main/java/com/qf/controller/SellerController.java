package com.qf.controller;


import com.qf.pojo.SellerInfo;
import com.qf.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    /*
    查询该商店的商品并分页
     */

    @RequestMapping(value = "listGoodsOfSellerById",method = RequestMethod.GET)
    public Map<String,Object> listGoodsOfSellerById(HttpServletRequest request){

        Map<String,Object> result = new HashMap<String, Object>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");
        String strsellerId = request.getParameter("sellerId");
        int draw =strdraw==null?0:Integer.parseInt(strdraw);
        int start =strdraw==null?0:Integer.parseInt(strstart);
        int length =strdraw==null?10:Integer.parseInt(strlength);
        int sellerId =strdraw==null?0:Integer.parseInt(strsellerId);
        System.out.println(sellerId);
        result.put("draw",draw);
        result.put("recordsTotal",sellerService.counts(sellerId));
        result.put("recordsFiltered",sellerService.counts(sellerId));
        result.put("data",sellerService.pages(start,length,sellerId));
        result.put("error","");
        return result;
    }
    /**
     * 商家图片添加
     */
    public static  String icon;
    @ResponseBody
    @RequestMapping(value="upload",method=RequestMethod.POST)
    public String upload(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
         icon = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = "D:\\j1901\\第三阶段代码\\your_shop\\your_shop_admin\\src\\main\\webapp\\images";
        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(filePath,icon);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 写入文件
            dropzFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }
    /**
     * 新增商家信息录入
     */
    @ResponseBody
    @RequestMapping("insertSellerInfo")
    public Object insertSellerInfo(@RequestBody SellerInfo sellerInfo){
        sellerInfo.setIcon("images/"+icon);
        return sellerService.insertSellerInfo(sellerInfo);
    }
}
