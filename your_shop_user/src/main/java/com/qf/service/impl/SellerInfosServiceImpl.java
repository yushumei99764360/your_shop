package com.qf.service.impl;

import com.qf.mapper.SellerInfoMapper;
import com.qf.service.SellerInfosService;
import com.qf.vo.SellerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerInfosServiceImpl implements SellerInfosService {

    @Autowired
    SellerInfoMapper sellerInfoMapper;

    /**
     *  商家注册
     * @param sellerInfoVo
     * @return
     */
    @Override
    public Boolean RegisterSellerInfo(SellerInfoVo sellerInfoVo) {
        Integer count = sellerInfoMapper.RegisterSellerInfo(sellerInfoVo);
        if(count>0){
            return true;
        }
        return false;
    }

    /**
     * 判断商家是否存在
     * @param s_name
     * @return
     */
    @Override
    public Integer checkSellerName(String s_name) {
        return sellerInfoMapper.checkSellerName(s_name);
    }
}
