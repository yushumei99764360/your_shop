package com.qf.controller;

import com.qf.dto.*;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "categoryList",method = RequestMethod.GET)
    public Object categoryList() {
        //System.out.println(1);
        //System.out.println(categories1);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "categoryListOne",method = RequestMethod.GET)
    public Object categoryListOne() {

        return "";
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
