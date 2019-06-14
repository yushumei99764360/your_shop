package com.qf.mapper;

import com.qf.dto.AddressInfoDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.CartInfo;
import com.qf.pojo.Order_Detail;
import com.qf.vo.CartInfoVo;

import java.util.List;

public interface CartInfoMapper {
    /**
     * 添加购物车
     * @param cartInfoVo
     * @return
     */
    int insertIntoCartInfo(CartInfoVo cartInfoVo);
    /**
     * 显示购物车列表
     * @param userId
     * @return
     */

    List<CartInfo> listMyCartInfo(int userId);

    /**
     * 获取地址
     * @param adsId
     * @return
     */

    AddressInfo getAddressInfoById(int adsId);

    /**
     * 订单添加
     * @param addressInfoDto
     * @return
     */

    int insertOrderInfo(AddressInfoDto addressInfoDto);

    /**
     * 订单详情添加
     * @param order_detail
     * @return
     */

    int insertOrderDetails(Order_Detail order_detail);

    /**
     * 购物车对应数据删除
     * @param
     * @return
     */

    int deleteCartInfoSelected(List<Integer> cartIds);

    /**
     * 购物车单个删除
     * @param cartId
     * @return
     */

    int deleteCartInfoById(int cartId);
}
