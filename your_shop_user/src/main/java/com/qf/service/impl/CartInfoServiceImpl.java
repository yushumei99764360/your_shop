package com.qf.service.impl;

import com.qf.dto.AddressInfoDto;
import com.qf.mapper.CartInfoMapper;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.CartInfo;
import com.qf.pojo.Order_Detail;
import com.qf.service.CartInfoService;
import com.qf.vo.CartInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartInfoServiceImpl implements CartInfoService {

    @Autowired
    CartInfoMapper cartInfoMapper;

    /**
     * 添加购物车
     * @param cartInfoVo
     * @return
     */

    @Override
    public boolean insertIntoCartInfo(CartInfoVo cartInfoVo) {

        int i = cartInfoMapper.insertIntoCartInfo(cartInfoVo);

        System.out.println(i);
        if (i != 0) {
            return true;
        }
        return false;
    }
    /**
     * 显示购物车列表
     * @param userId
     * @return
     */

    @Override
    public List<CartInfo> listMyCartInfo(int userId) {
        return cartInfoMapper.listMyCartInfo(userId);
    }

    /**
     * 获取地址
     * @param adsId
     * @return
     */
    @Override
    public AddressInfo getAddressInfoById(int adsId) {
        return cartInfoMapper.getAddressInfoById(adsId);
    }

    /**
     * 订单添加
     * @param addressInfoDto
     * @return
     */

    @Override
    public boolean insertOrderInfo(AddressInfoDto addressInfoDto) {
        int i= cartInfoMapper.insertOrderInfo(addressInfoDto);
        if (i != 0) {
            return true;
        }
        return false;
    }

    /**
     * 订单详情添加
     * @param selectCartInfos
     * @param id
     * @return
     *  int id;
     *      Date order_date;
     *      int o_orderid;
     *      int g_id;
     *      String g_name;
     *      double g_disctprice;
     *      String  g_desc;
     *      int g_num;
     *      double g_total_price;
     *      String g_pic;
     *      Date order_modified;
     */
    @Override
    public boolean insertOrderDetails(List<CartInfo> selectCartInfos, int id) {
        Order_Detail order_detail = new Order_Detail();
        order_detail.setO_orderid(id);
        boolean flag = false;
        for (CartInfo cartInfo : selectCartInfos) {
            order_detail.setG_disctprice(cartInfo.getG_disctprice());
            order_detail.setG_id(cartInfo.getG_id());
            order_detail.setG_name(cartInfo.getG_name());
            order_detail.setG_num(cartInfo.getProduct_amount());
            order_detail.setG_total_price(cartInfo.getSum_price());
            order_detail.setG_pic(cartInfo.getG_pic());
            int i = cartInfoMapper.insertOrderDetails(order_detail);
            if (i != 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 购物车对应数据删除
     * @param selectCartInfos
     * @return
     */

    @Override
    public boolean deleteCartInfoSelected(List<CartInfo> selectCartInfos) {
        List<Integer> cartIds = new ArrayList<>();
        for (CartInfo cartInfo : selectCartInfos) {
            cartIds.add(cartInfo.getCart_id());
        }
        int i = cartInfoMapper.deleteCartInfoSelected(cartIds);
        if (i != 0) {
            return true;
        }
        return false;
    }

    /**
     * 购物车单个删除
     * @param cartId
     * @return
     */

    @Override
    public boolean deleteCartInfoById(int cartId) {
        int i = cartInfoMapper.deleteCartInfoById(cartId);
        if (i != 0) {
            return true;
        }
        return false;
    }

}
