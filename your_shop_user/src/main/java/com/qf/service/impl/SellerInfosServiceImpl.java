package com.qf.service.impl;

import com.qf.mapper.SellerInfoMapper;
import com.qf.pojo.GoodsInfo;
import com.qf.service.SellerInfosService;
import com.qf.vo.SellerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据商家ID找出所有商品信息
     * @param s_id
     * @return
     */
    @Override
    public List<GoodsInfo> SelectGoodsBySellerID(Integer s_id) {
        return sellerInfoMapper.SelectGoodsBySellerID(s_id);
    }
}
