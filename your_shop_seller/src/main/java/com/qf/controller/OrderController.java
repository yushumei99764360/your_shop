package com.qf.controller;

import com.qf.service.OrderService;

import com.qf.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
//    查询基本订单信息
    @ResponseBody
    @RequestMapping("getAllOrder")
//    @RequestParam int goodsId
    public Object getAllOrderInfo(){
        List<OrderVo> orderInfoList = orderService.getAllOrderInfo();
        return orderInfoList;
    }


//    查询订单详情
    @ResponseBody
    @RequestMapping("getOrderDetail")
//    @RequestParam int goodsId
    public Object getOrderDetail(@RequestParam int id){
        System.out.println(id);
        List<OrderVo> orderDetailList = orderService.getOrderDetail(id);
        System.out.println(orderDetailList);
        return orderDetailList;
    }




}
