package com.qf.controller;

import com.qf.dto.OrdersOfUserDto;
import com.qf.pojo.UserInfo;
import com.qf.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;

    @RequestMapping(value = "getOrdersOfUser")
    public Object getOrdersOfUser(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        System.out.println(userInfo.getUserId());
        List<OrdersOfUserDto> ordersOfUser = orderInfoService.getOrdersOfUser(userInfo.getUserId());
        System.out.println(ordersOfUser);
        return ordersOfUser;
    }
}
