package com.qf.controller;

import com.qf.dto.*;
import com.qf.pojo.GoodsInfo;
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


    @ResponseBody
    @RequestMapping(value = "getSonCategory",method = RequestMethod.GET)
    public Object getSonCategory() {
        List<GoodsInfo> sonCategory = categoryService.getSonCategory();
        System.out.println(sonCategory);
        return sonCategory;
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
    public Object createOrder(@RequestBody CreateOrderDto createOrderDto,HttpSession session){

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

        session.setAttribute("addressInfoDto",addressInfoDto);
        //下订单
        int i= categoryService.insertOrder(addressInfoDto);
        //获取商品信息
        GodsInfoDetail goodsInfoDetail = categoryService.searchGoods(createOrderDto.getG_id());
        //赋值
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

    /**
     * 获取订单详细信息
     */
    @ResponseBody
    @RequestMapping("getOrderDetail")
    public Object getOrderDetail(HttpSession httpSession){
        AddressInfoDto addressInfoDto = (AddressInfoDto) httpSession.getAttribute("addressInfoDto");
        return addressInfoDto;
    }

    /**
     * 获取物流信息
     */
    @ResponseBody
    @RequestMapping(value = "getlogistics", method = RequestMethod.POST)
    public Object getlogistics(@RequestBody Logisticsinfo logisticsinfo){
        return categoryService.getlogistics(logisticsinfo.getG_id());
    }
}
