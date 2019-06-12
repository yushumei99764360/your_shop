package com.qf.service.impl;

import com.qf.dto.OrdersOfUserDto;
import com.qf.mapper.OrderInfoMapper;
import com.qf.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    /**
     * 个人订单查询
     *
     * @param userId
     * @return
     */
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrdersOfUserDto> getOrdersOfUser(int userId) {
        return orderInfoMapper.getOrdersOfUser(userId);
    }

}
