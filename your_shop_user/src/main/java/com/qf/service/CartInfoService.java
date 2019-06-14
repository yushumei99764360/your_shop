package com.qf.service;

import com.qf.dto.AddressInfoDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.CartInfo;
import com.qf.vo.CartInfoVo;

import java.util.List;

public interface CartInfoService {
    /**
     * 添加购物车
     * @param cartInfoVo
     * @return
     */
    boolean insertIntoCartInfo(CartInfoVo cartInfoVo);

    /**
     * 显示购物车列表
     * @param userId
     * @return
     */

    List<CartInfo> listMyCartInfo(int userId);

    AddressInfo getAddressInfoById(int adsId);

    /**
     * 添加订单
     * @param addressInfoDto
     * @return
     */

    boolean insertOrderInfo(AddressInfoDto addressInfoDto);

    /**
     * 添加订单详情
     * @param selectCartInfos
     * @param id
     * @return
     */

    boolean insertOrderDetails(List<CartInfo> selectCartInfos, int id);

    /**
     * 订单添加成功后，删除购物车中相应数据
     * @param selectCartInfos
     * @return
     */

    boolean deleteCartInfoSelected(List<CartInfo> selectCartInfos);
}
