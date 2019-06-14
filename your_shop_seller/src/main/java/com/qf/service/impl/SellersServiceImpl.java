package com.qf.service.impl;

import com.qf.mapper.SellersMapper;
import com.qf.pojo.SellerInfo;
import com.qf.service.SellersService;
import com.qf.vo.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellersServiceImpl implements SellersService {

    @Autowired
    SellersMapper sellersMapper;

    //    店家后台登录
    public SellerInfo loginSeller(SellerVo sellerVo) {

        return sellersMapper.loginSeller(sellerVo);

    }

    //    根据商家id 查询商家详细信息
    public SellerInfo getSellerById(int s_id) {

        return sellersMapper.getSellerById(s_id);
    }

    //    修改商家信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateSeller(SellerVo sellerVo) {
        int updateSeller = sellersMapper.updateSeller(sellerVo);
        if (updateSeller>0)
            return true;
        return false;
    }

    //修改商家头像
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updatePicBySellerId(String s_code, String icon) {
        int updatePicBySellerId = sellersMapper.updatePicBySellerId(s_code, icon);
        if (updatePicBySellerId>0)
            return true;
        return false;
    }
}
