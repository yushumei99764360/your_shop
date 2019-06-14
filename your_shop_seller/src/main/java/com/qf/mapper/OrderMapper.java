package com.qf.mapper;

import com.qf.vo.OrderSelected;
import com.qf.vo.OrderVo;
import com.qf.vo.RefundVo;

import java.util.List;

public interface OrderMapper {
//    显示基本订单信息
    List<OrderVo> getAllOrderInfo() ;

    List<OrderVo> getOrderDetail(int id);

    boolean updateOrderInfo(OrderVo orderVo);

    boolean deleteOrderInfo(int id);

    List<OrderVo> selectOrderBy(OrderSelected orderSelected);

    Object deleteSelectOrder(List<Integer> selectOrderId);

    List<OrderVo> selectByPlace();

    OrderVo selectByOrderNum();

    OrderVo selectByGoodsNum();

    List<OrderVo> getAllRefund();

    RefundVo getRefundInfoById(int id);
}
