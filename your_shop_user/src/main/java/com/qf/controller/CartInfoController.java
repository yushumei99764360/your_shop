package com.qf.controller;

import com.qf.dto.AddressInfoDto;
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
import java.util.Random;

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
        AddressInfo addressInfo =  cartInfoService.getAddressInfoById(insertOrderDto.getAdsId());
        System.out.println(addressInfo);
        //随机数编号
        int id = (int) new Random().nextInt(1000000);
        //订单添加 传值对象
        AddressInfoDto addressInfoDto = new AddressInfoDto();

        addressInfoDto.setAdsId(addressInfo.getAdsId());
        addressInfoDto.setCity(addressInfo.getCity());
        addressInfoDto.setDistrict(addressInfo.getDistrict());
        addressInfoDto.setId(id);
        addressInfoDto.setO_sendtype(insertOrderDto.getO_sendtype());
        addressInfoDto.setPrice(insertOrderDto.getO_paycount());
        addressInfoDto.setProvince(addressInfo.getProvince());
        addressInfoDto.setS_id(insertOrderDto.getS_id());
        addressInfoDto.setShname(addressInfo.getShname());
        addressInfoDto.setShphone(addressInfo.getShphone());
        addressInfoDto.setStreet(addressInfo.getStreet());
        addressInfoDto.setUserId(userInfo.getUserId());

        //添加订单
        System.out.println(addressInfoDto);
        boolean flag1 =  cartInfoService.insertOrderInfo(addressInfoDto);

        //添加订单详情
        boolean flag2 = cartInfoService.insertOrderDetails(selectCartInfos,id);

        //删除购物车信息(订单添加成功，删除购物车表中对应数据)
        boolean flag3 = false;
        if (flag1 && flag2) {
            flag3 = cartInfoService.deleteCartInfoSelected(selectCartInfos);
        }


        return flag1&&flag2&&flag3;
    }

}
