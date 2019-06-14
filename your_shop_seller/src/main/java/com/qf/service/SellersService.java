package com.qf.service;

import com.qf.pojo.SellerInfo;
import com.qf.vo.SellerVo;
import org.apache.ibatis.annotations.Param;

public interface SellersService {

    //    店家后台登录
    SellerInfo loginSeller(SellerVo sellerVo);
    //    根据商家id 查询商家详细信息
    SellerInfo getSellerById(int s_id);
    //    修改商家信息
    boolean updateSeller(SellerVo sellerVo);

    //    修改商家头像
    boolean updatePicBySellerId(String s_code, String icon);

}
