package com.qf.mapper;

import com.qf.dto.OrdersOfUserDto;

import java.util.List;

public interface OrderInfoMapper {
    /**
     * 个人订单查询
     * @param userId
     * @return
     */
    List<OrdersOfUserDto> getOrdersOfUser(int userId);
}
