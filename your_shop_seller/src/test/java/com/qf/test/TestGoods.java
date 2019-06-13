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
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setS_id(1);
        goodsVo.setChildId(23);
        goodsVo.setG_title("cedds");
        goodsVo.setG_name("cedss11");
        boolean goodsInfo = goodsService.addGoodsInfo(goodsVo);
        System.out.println(goodsInfo);

    }

    @Test
    public void test4(){
        GoodsSelecteds goodsSelecteds = new GoodsSelecteds();
        goodsSelecteds.setStr("果");
        goodsSelecteds.setSellerId(1);
        goodsSelecteds.setG_status(0);
        List<GoodsVo> goodsVos = goodsService.selectGoodsBys(goodsSelecteds);
        System.out.println(goodsVos);
    }

    @Test
    public void test5(){
        boolean iconByGId = goodsService.updateIconByGId(158, "images/dd.jpg");
        System.out.println(iconByGId);

    }
    @Test
    public void test6(){

    }

}
