package com.qf.controller;


import com.qf.pojo.Category;
import com.qf.pojo.SellerInfo;
import com.qf.service.CategoryService;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;

    // 查询所有商品信息  商品列表页面
    @ResponseBody
    @RequestMapping("getAllGoods")
    public Object getAllGoodsInfo(HttpSession httpSession){
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        int s_id = sellerInfo.getS_id();
        System.out.println(s_id);
        List<GoodsVo> goodsInfoList = goodsService.getAllGoods(s_id);
        System.out.println(goodsInfoList);
        return goodsInfoList;
    }

    // 实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
    @ResponseBody
    @RequestMapping("addGoodsInfo")
    public Object addGoods(@RequestBody GoodsVo goodsVo,HttpSession httpSession ){

        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        goodsVo.setS_id(sellerInfo.getS_id());
        String pic = goodsVo.getG_pic();
        if (pic.length()>0)
            goodsVo.setG_pic("http://localhost:8080/seller/static/upload/"+pic);
//        goodsVo.setG_pic("images/"+icon);
        System.out.println(goodsVo);
        boolean addGoods = goodsService.addGoodsInfo(goodsVo);
        System.out.println(addGoods);
        return addGoods;
    }

    //实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    @ResponseBody
    @RequestMapping("getGoodsByGoodsId")
    public Object getGoodsByGoodsId(@RequestParam int goodsId){
        System.out.println(goodsId);
        GoodsVo goodsInfoByGoodsId = goodsService.getGoodsInfoByGoodsId(goodsId);
        List<Category> categoryList = categoryService.getChildInfo();
        goodsInfoByGoodsId.setCategoryList(categoryList);
        System.out.println(goodsInfoByGoodsId);
        return goodsInfoByGoodsId;
    }
    @ResponseBody
    @RequestMapping("updateGoodsByGoodsId")
    public Object updateGoodsInfo(@RequestBody GoodsVo goodsVo) {
        System.out.println(goodsVo);
        goodsVo.setG_pic("http://localhost:8080/seller/static/upload/"+goodsVo.getG_pic());
        boolean uodateGoodsInfo = goodsService.uodateGoodsInfo(goodsVo);
        System.out.println(uodateGoodsInfo);
        return uodateGoodsInfo;
    }

    //    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    @ResponseBody
    @RequestMapping("getGoodsBys")
    public Object getGoodsBys(@RequestBody GoodsSelecteds goodsSelecteds , HttpSession httpSession) {
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        goodsSelecteds.setSellerId(sellerInfo.getS_id());
        System.out.println(goodsSelecteds);
        List<GoodsVo> goodsVos = goodsService.selectGoodsBys(goodsSelecteds);
        System.out.println(goodsVos);
        return goodsVos;
    }

    //根据商品id 删除商品信息
    @ResponseBody
    @RequestMapping("delByGoodsId")
    public Object delByGoodsId(@RequestParam int goodsId) {
        System.out.println(goodsId);
        boolean delByGoodsId = goodsService.delByGoodsId(goodsId);
        System.out.println(delByGoodsId);
        return delByGoodsId;
    }

    // 删除选中的，批量删除
    @ResponseBody
    @RequestMapping("delCheckGoods")
    public Object delCheckGoods(@RequestBody List<Integer> selectedGoodsId){
        System.out.println(selectedGoodsId);
        boolean delCheckGoods = goodsService.delCheckGoods(selectedGoodsId);
        System.out.println(delCheckGoods);
        return delCheckGoods;
    }
//    商品图片上传修改替换
//    @ResponseBody
    @RequestMapping(value = "picUpload", method = RequestMethod.POST)
    public Object  iconUpload(@RequestParam("goodsId") int goodsId , @RequestParam("file") CommonsMultipartFile file) {

        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:\\Java1901\\your_shop\\your_shop_seller\\src\\main\\webapp\\images"+file.getOriginalFilename();

        String icon = "images/"+file.getOriginalFilename();
        File newFile=new File(path);
        boolean flag = false;
        try {
            file.transferTo(newFile);
            flag =  goodsService.updateIconByGId(goodsId, icon);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 商品图片添加
     */
    public static  String icon;

   /* @RequestMapping(value="uploadPic",method=RequestMethod.POST)
    public String uploadPic(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        icon = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = "D:\\Java1901\\your_shop\\your_shop_seller\\src\\main\\webapp\\images";
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
    }*/
    @ResponseBody
    @RequestMapping(value="uploadPic",method=RequestMethod.POST)
    public Map<String,Object> uploadPic(MultipartFile dropzFile, HttpServletRequest request) throws IOException {

        System.out.println(dropzFile);
        Map<String,Object> result = new HashMap<String, Object>();
        // 获取上传文件名
        String fileName = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("/static/upload");
//        获取文件的后缀名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
//        重新设置文件名为UUID
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        System.out.println(file.getAbsoluteFile());
        if(!file.exists()){
            try {
                file.createNewFile();
//                写入文件
                dropzFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        返回JSON数据，这里只带入了文件名
        result.put("fileName",file.getName());
        return result;
    }
}
