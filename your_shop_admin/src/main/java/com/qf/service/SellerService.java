package com.qf.service;

import com.qf.pojo.GoodsInfo;
import com.qf.pojo.SellerInfo;

import java.util.List;

public interface SellerService {
    List<SellerInfo> listAllSellerInfo();

    int count();

    List<SellerInfo> page(int start, int length);

    boolean deleteSellerInfoById(int s_id);

    int counts(int sellerId);

    List<GoodsInfo> pages(int start, int length, int sellerId);

    int insertSellerInfo(SellerInfo sellerInfo);

    SellerInfo getSellerInfoById(int sellerId);

    /**
     * 添加头像
     * @param sellerId
     * @param icon
     * @return
     */

    boolean updateIconBySellerId(int sellerId, String icon);

    /**
     * 修改商家信息
     * @param sellerInfo
     * @return
     */
    boolean updateSellerInfo(SellerInfo sellerInfo);

    /**
     * 该商店的订单总数
     * @param sellerId
     * @return
     */

    int countOrderOfSeller(int sellerId);

    /**
     * 商店的订单分页查询
     * @param start
     * @param length
     * @param sellerId
     * @return
     */

    List<SellerInfo> pageOrdersOfSeller(int start, int length, int sellerId);
}
