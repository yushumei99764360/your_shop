package com.qf.controller;

import com.qf.dto.*;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 页面商品分类
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllCategory",method = RequestMethod.GET)
    public Object findAllCategory() {
        //System.out.println(1);
        List<GoodsInfo> allCategory = categoryService.findAllCategory();
        System.out.println(allCategory);
        return allCategory;
    }
    // 查询所有一级类别
    @RequestMapping("getAllCategoryFather")
    public Object getAllCategoryFather(){
        List<Category> fatherInfos = categoryService.getFatherInfo();
        return fatherInfos;
    }

    // 查询所有一级类别
    @ResponseBody
    @RequestMapping("getAllChildInfo")
    public Object getAllChildInfo(){
        List<Category> childInfos = categoryService.getChildInfo();
        return childInfos;
    }

    // 根据父类id 查询它所包含的所有子类信息
    @ResponseBody
    @RequestMapping("getChildCategoryInfo")
    public Object getChildCategoryInfo(@RequestParam int fatherId) {
        CategoryVo categoryVo = categoryService.getChildCategoryInfo(fatherId);
        return categoryVo;
    }

    // 根据 所有父类 和 它所包含的所有子类信息
    @ResponseBody
    @RequestMapping("getAllChildCategoryInfo")
    public Object getAllChildCategoryInfo() {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<Category> fatherInfo = categoryService.getFatherInfo();
        for (int i = 0 ; i<fatherInfo.size();i++){
            CategoryVo categoryVo = categoryService.getChildCategoryInfo(fatherInfo.get(i).getC_id());
            categoryVoList.add(categoryVo);
            System.out.println(categoryVo);
        }
        return categoryVoList;
    }


    @ResponseBody
    @RequestMapping(value = "goodsList")
    public Object goods() {
        List<GoodsInfo> goods = categoryService.goods();
        System.out.println(goods);
        return goods;
    }


    /**
     * 商品信息展示
     */
    @ResponseBody
    @RequestMapping("getGoodsInfoById")
    public Object getGoodsInfoById(@RequestParam int g_id){
        return categoryService.getGoodsInfoById(g_id);
    }

    /**
     * 订单创建
     */
    @ResponseBody
    @RequestMapping("createOrder")
    public Object createOrder(@RequestBody CreateOrderDto createOrderDto){
        System.out.println(createOrderDto);
        int adsId = createOrderDto.getAddress();
        //查询选择的地址
        AddressInfoDto addressInfoDto = categoryService.searchAddress(adsId);
        //订单编号
        int id = (int) new Random().nextInt(1000000);
        //快递公司
        addressInfoDto.setO_sendtype(createOrderDto.getExpress());
        //快递编号
        addressInfoDto.setId(id);
        //店铺编号
        addressInfoDto.setS_id(createOrderDto.getS_id());
        //总价
        addressInfoDto.setPrice(createOrderDto.getPrice()*createOrderDto.getNum());
        System.out.println(addressInfoDto);
        //下订单
        int i= categoryService.insertOrder(addressInfoDto);
        System.out.println(i);
        //获取商品信息
        GodsInfoDetail goodsInfoDetail = categoryService.searchGoods(createOrderDto.getG_id());

        Order_DetailDto order_detailDto = new Order_DetailDto();
        order_detailDto.setG_total_price(createOrderDto.getPrice()*createOrderDto.getNum());
        order_detailDto.setO_orderid(id);
        order_detailDto.setG_disctprice(goodsInfoDetail.getG_disctprice());
        order_detailDto.setG_id(createOrderDto.getG_id());
        order_detailDto.setG_num(createOrderDto.getNum());
        order_detailDto.setG_desc(goodsInfoDetail.getG_desc());
        order_detailDto.setG_pic(goodsInfoDetail.getG_pic());
        order_detailDto.setG_name(goodsInfoDetail.getG_name());
        //添加订单详情表
        int j = categoryService.insertOrderDetail(order_detailDto);
        if (j!=0&&i!=0){
            return true;
        }
        return false;
    }
}
