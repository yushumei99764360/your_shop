package com.qf.mapper;

import com.qf.vo.CartInfoVo;

public interface CartInfoMapper {
    /**
     * 添加购物车
     * @param cartInfoVo
     * @return
     */
    int insertIntoCartInfo(CartInfoVo cartInfoVo);
}
