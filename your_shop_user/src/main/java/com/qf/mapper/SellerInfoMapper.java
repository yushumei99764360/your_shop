package com.qf.mapper;

import com.qf.pojo.GoodsInfo;
import com.qf.vo.SellerInfoVo;

import java.util.List;

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

    /**
     * 根据商家ID找出所有商品信息
     * @param s_id
     * @return
     */
    public List<GoodsInfo> SelectGoodsBySellerID(Integer s_id);
}
