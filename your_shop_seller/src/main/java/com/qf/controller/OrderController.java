package com.qf.controller;

import com.qf.service.OrderService;

import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import com.qf.vo.OrderSelected;
import com.qf.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<OrderVo> orderDetailList = orderService.getOrderDetail(id);
        return orderDetailList;
    }

//    根据订单号修改订单信息
    @ResponseBody
    @RequestMapping("updateOrderInfo")
    public Object updateOrderInfo(@RequestBody OrderVo orderVo) {
        boolean updateOrder = orderService.updateOrderInfo(orderVo);
        return updateOrder;
    }

//    根据订单号删除订单
@ResponseBody
@RequestMapping("deleteOrderInfo")
public Object deleteOrderInfo(@RequestParam int id) {
    boolean deleteOrder = orderService.deleteOrderInfo(id);
    return deleteOrder;
}

//    根据 创建修改日期    关键词搜索 订单列表
    @ResponseBody
    @RequestMapping("selectOrderBy")
    public Object selectOrderBy(@RequestBody OrderSelected orderSelected) {
        List<OrderVo> orderVos = orderService.selectOrderBy(orderSelected);
        return orderVos;
    }

//    批量删除
@ResponseBody
@RequestMapping("deleteSelectOrder")
public Object deleteSelectOrder(@RequestBody List<Integer> selectOrderId){

    return orderService.deleteSelectOrder(selectOrderId);
}
//echarts图表
    @ResponseBody
    @RequestMapping("selectByPlace")
    public Object selectByPlace(){
        List<OrderVo> orderVo1 = orderService.selectByPlace();
        return orderVo1;
    }

//获取订单数量和金额
    @ResponseBody
    @RequestMapping("selectByOrderNum")
    public Object selectByOrderNum(){
        OrderVo orderVo2 = orderService.selectByOrderNum();
        return orderVo2;
    }

//    获取商品数量
    @ResponseBody
    @RequestMapping("selectByGoodsNum")
    public Object selectByGoodsNum(){
        OrderVo orderVo3 = orderService.selectByGoodsNum();
        return orderVo3;
    }
}
