package com.qf.service;

import com.qf.vo.SellerInfoVo;

public interface SellerInfosService {
    /**
     * 注册商家信息
     * @param sellerInfoVo
     * @return
     */
    public Boolean RegisterSellerInfo(SellerInfoVo sellerInfoVo);
    /**
     * 判断商家是否存在
     * @param s_name
     * @return
     */
    public Integer checkSellerName(String s_name);
}
