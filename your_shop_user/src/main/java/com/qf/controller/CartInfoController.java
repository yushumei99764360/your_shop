package com.qf.controller;

import com.qf.dto.InsertOrderDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.CartInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.CartInfoService;
import com.qf.vo.CartInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CartInfoController {

    @Autowired
    CartInfoService cartInfoService;

    @RequestMapping(value = "insertIntoCartInfo")
    public Object insertIntoCartInfo(@RequestBody  CartInfoVo cartInfoVo, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        cartInfoVo.setUserId(userInfo.getUserId());
        boolean flag = cartInfoService.insertIntoCartInfo(cartInfoVo);
        return flag;
    }

    @RequestMapping(value = "listMyCartInfo")
    public Object listMyCartInfo(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        List<CartInfo> cartInfoList = cartInfoService.listMyCartInfo(userInfo.getUserId());
        return cartInfoList;
    }

    /**
     * 将选中的cartInfos放入session中
     * @param selectCartInfos
     * @param session
     * @return
     */
    @RequestMapping(value = "putSelectCartInfosIntoSession")
    public Object putSelectCartInfosIntoSession(@RequestBody List<CartInfo> selectCartInfos, HttpSession session) {
        System.out.println(selectCartInfos);
        session.setAttribute("selectCartInfos", selectCartInfos);
        return true;
    }



    /**
     * 将选中的cartInfos返回
     * @param session
     * @return
     */
    @RequestMapping(value = "getCartInfosSelected")
    public Object getCartInfosSelected( HttpSession session) {
        List<CartInfo> selectCartInfos = (List<CartInfo>) session.getAttribute("selectCartInfos");
        return selectCartInfos;
    }


    /**
     * 从购物车结算页面添加订单
     * @param session
     * @return
     */
    @RequestMapping(value = "insertOrderInfo")
    public Object insertOrderInfo(@RequestBody InsertOrderDto insertOrderDto, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        List<CartInfo> selectCartInfos = (List<CartInfo>) session.getAttribute("selectCartInfos");
//        AddressInfo addressInfo =  cartInfoService.getAddressInfoById(insertOrderDto.getAdsId());
        return null;
    }

}
