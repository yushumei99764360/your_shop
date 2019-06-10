package com.qf.mapper;

import com.qf.vo.OrderVo;

import java.util.List;

public interface OrderMapper {
//    显示基本订单信息
    List<OrderVo> getAllOrderInfo() ;

    List<OrderVo> getOrderDetail(int id);
}
