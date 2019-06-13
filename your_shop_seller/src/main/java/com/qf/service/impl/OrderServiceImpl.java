package com.qf.service.impl;

import com.qf.mapper.GoodsMapper;
import com.qf.mapper.OrderMapper;
import com.qf.service.OrderService;
import com.qf.vo.GoodsVo;
import com.qf.vo.OrderSelected;
import com.qf.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<OrderVo> getAllOrderInfo() {

        return orderMapper.getAllOrderInfo();
    }

    @Override
    public List<OrderVo> getOrderDetail(int id) {
        return orderMapper.getOrderDetail(id);
    }

    @Override
    public boolean updateOrderInfo(OrderVo orderVo) {

        return orderMapper.updateOrderInfo(orderVo);
    }

    @Override
    public boolean deleteOrderInfo(int id) {

        return orderMapper.deleteOrderInfo( id);
    }

    @Override
    public List<OrderVo> selectOrderBy(
            OrderSelected orderSelected) {
        return orderMapper.selectOrderBy(orderSelected);
    }

    @Override
    public Object deleteSelectOrder(List<Integer> selectOrderId) {
        return orderMapper.deleteSelectOrder(selectOrderId);
    }

    @Override
    public List<OrderVo> selectByPlace() {
        return orderMapper.selectByPlace();
    }

    @Override
    public OrderVo selectByOrderNum() {
        return orderMapper.selectByOrderNum();
    }

    @Override
    public OrderVo selectByGoodsNum() {
        return orderMapper.selectByGoodsNum();
    }


}
