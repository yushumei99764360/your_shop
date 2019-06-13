package com.qf.controller;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.CategoryDto;
import com.qf.dto.CreateOrderDto;
import com.qf.dto.OrdersOfUserDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 页面商品分类
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "categoryList",method = RequestMethod.GET)
    public Object categoryList() {
        //System.out.println(1);
        //System.out.println(categories1);
        return categoryService.categoryList();
    }

    @ResponseBody
    @RequestMapping(value = "categoryListOne",method = RequestMethod.GET)
    public Object categoryListOne() {
        List<CategoryDto> categoryDtos = categoryService.categoryListOne();
        return categoryDtos;
    }

    /**
     * 商品信息展示
     */
    @ResponseBody
    @RequestMapping("getGoodsInfoById")
    public Object getGoodsInfoById(@RequestParam int g_id){
        return categoryService.getGoodsInfoById(g_id);
    }


    /**
     * 订单创建
     */
    @ResponseBody
    @RequestMapping("createOrder")
    public Object createOrder(@RequestBody CreateOrderDto createOrderDto){
        System.out.println(createOrderDto);
        int adsId = createOrderDto.getAddress();
        AddressInfoDto addressInfoDto = categoryService.searchAddress(adsId);
        //订单编号
        int id = (int) new Random().nextInt(100000);
        addressInfoDto.setO_sendtype(createOrderDto.getExpress());
        addressInfoDto.setId(id);
        //下单
        int i= categoryService.insertOrder(addressInfoDto);

        return "";
    }
}
