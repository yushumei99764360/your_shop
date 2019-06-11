package com.qf.test;

import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestGoods {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    GoodsService goodsService = context.getBean(GoodsService.class);

    @Test
    public void test1(){
        List<GoodsVo> goods = goodsService.getAllGoods(1);

        for (GoodsVo goods1: goods)
            System.out.println(goods1);
    }

    @Test
    public void test2(){
     /*   GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setG_name("香蕉");
        goodsInfo.setS_id(20000043);
        boolean addGoods = goodsService.addGoods(goodsInfo);
        System.out.println(addGoods);
*/

    }

    @Test
    public void test3(){

        GoodsSelecteds goodsSelecteds = new GoodsSelecteds();
        goodsSelecteds.setSellerId(1);
        goodsSelecteds.setStr("");
        goodsSelecteds.setCategoryName("手机");
        goodsSelecteds.setG_status(0);
        goodsSelecteds.setMinDate("");
        goodsSelecteds.setMaxDate("");

        List<GoodsVo> goods = goodsService.selectGoodsBys(goodsSelecteds);

        for (GoodsVo goods1: goods)
            System.out.println(goods1);

    }

    @Test
    public void test4(){



    }

    @Test
    public void test5(){



    }
    @Test
    public void test6(){

    }

}
