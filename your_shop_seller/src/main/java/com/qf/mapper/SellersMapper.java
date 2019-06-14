package com.qf.mapper;

import com.qf.pojo.SellerInfo;
import com.qf.vo.SellerVo;
import org.apache.ibatis.annotations.Param;

public interface SellersMapper {
//    店家后台登录
    SellerInfo loginSeller(SellerVo sellerVo);
//    根据商家id 查询商家详细信息
    SellerInfo getSellerById(int s_id);
//    修改商家信息
    int updateSeller(SellerVo sellerVo);

    //    修改商家头像
    int updatePicBySellerId(@Param("s_code") String s_code, @Param("icon") String icon);

}
