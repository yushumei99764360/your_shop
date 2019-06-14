package com.qf.service;

import com.qf.vo.OrderSelected;
import com.qf.vo.OrderVo;
import com.qf.vo.RefundVo;

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
//模糊查询订单
     List<OrderVo> selectOrderBy(OrderSelected orderSelected);

    Object deleteSelectOrder(List<Integer> selectOrderId);

    List<OrderVo> selectByPlace();

    OrderVo selectByOrderNum();

    OrderVo selectByGoodsNum();

    List<OrderVo> getAllRefund();

    RefundVo getRefundInfoById(int id);
}
