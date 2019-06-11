package com.qf.test;

import com.qf.pojo.SellerInfo;
import com.qf.service.GoodsService;
import com.qf.service.SellersService;
import com.qf.vo.GoodsVo;
import com.qf.vo.SellerVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSeller {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    SellersService sellersService = context.getBean(SellersService.class);

    @Test
    public void test1(){
        SellerVo sellerVo = new SellerVo();
        sellerVo.setS_name("张家小店");
        sellerVo.setS_pwd("zy1234");
        SellerInfo sellerInfo = sellersService.loginSeller(sellerVo);
        System.out.println(sellerInfo);

    }
    @Test
    public void test2(){
        SellerVo sellerVo = new SellerVo();
        sellerVo.setS_id(3);
        sellerVo.setS_status("0");
        sellerVo.setIcon("zhYang.jsp");

        boolean sellerInfo = sellersService.updateSeller(sellerVo);
        System.out.println(sellerInfo);

    }
    @Test
    public void test3(){


    }
}
