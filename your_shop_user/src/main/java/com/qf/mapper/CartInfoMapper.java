package com.qf.mapper;

import com.qf.pojo.CartInfo;
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
}
