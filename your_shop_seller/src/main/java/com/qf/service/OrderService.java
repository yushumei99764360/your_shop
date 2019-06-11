package com.qf.service;

import com.qf.vo.OrderVo;

import java.util.List;

public interface OrderService {
//    查询基本信息
     List<OrderVo> getAllOrderInfo();
//查询订单详情
     List<OrderVo> getOrderDetail( int id);
//修改订单
     boolean updateOrderInfo(OrderVo orderVo);
//删除订单
     boolean deleteOrderInfo(int id);
}
