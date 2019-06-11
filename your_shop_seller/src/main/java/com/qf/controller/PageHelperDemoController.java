package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.SellerInfo;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageHelperDemoController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping(value="list",method= RequestMethod.GET)
    public Object pageList(@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo , HttpSession httpSession){
        Integer pageSize=4;//每页显示记录数
        SellerInfo sellerInfo = (SellerInfo) httpSession.getAttribute("sellerInfo");
        int s_id = sellerInfo.getS_id();
        System.out.println(s_id +"------"+ pageNo);
        //分页查询
        //PageHelper:mybatis分页查询插件工具类
        PageHelper.startPage(pageNo, pageSize);
        List<GoodsVo> goodsVoList = goodsService.getAllGoods(s_id);//获取所有用户信息
        System.out.println("goodsVoList : "+goodsVoList);
        //创建页面对象，存放UserInfo泛型的对象。将userList存放进去。
        PageInfo<GoodsVo> pageInfo=new PageInfo<GoodsVo>(goodsVoList);
        System.out.println(pageInfo);
        return pageInfo;
    }

}
