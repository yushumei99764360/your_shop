package com.qf.mapper;

import com.qf.vo.SellerInfoVo;

public interface SellerInfoMapper {
    /**
     * 注册商家信息
     * @param sellerInfoVo
     * @return
     */
    public Integer RegisterSellerInfo(SellerInfoVo sellerInfoVo);

    /**
     * 判断商家是否存在
     * @param s_name
     * @return
     */
    public Integer checkSellerName(String s_name);
}
