package com.qf.service;

import com.qf.vo.CartInfoVo;

public interface CartInfoService {
    /**
     * 添加购物车
     * @param cartInfoVo
     * @return
     */
    boolean insertIntoCartInfo(CartInfoVo cartInfoVo);
}
