package com.qf.service.impl;

import com.qf.mapper.CartInfoMapper;
import com.qf.service.CartInfoService;
import com.qf.vo.CartInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
