package com.qf.mapper;

import com.qf.pojo.SellerInfo;
import com.qf.vo.SellerVo;

public interface SellersMapper {
//    店家后台登录
    SellerInfo loginSeller(SellerVo sellerVo);
//    根据商家id 查询商家详细信息
    SellerInfo getSellerById(int s_id);
//    修改商家信息
    int updateSeller(SellerVo sellerVo);
}
