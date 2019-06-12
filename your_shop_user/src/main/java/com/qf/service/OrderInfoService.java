package com.qf.service;

import com.qf.dto.OrdersOfUserDto;

import java.util.List;

public interface OrderInfoService {

    /**
     * 个人订单查询
     * @param userId
     * @return
     */
    List<OrdersOfUserDto> getOrdersOfUser(int userId);
}
