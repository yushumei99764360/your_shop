package com.qf.service;

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
}
