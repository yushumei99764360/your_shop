package com.qf.mapper;

import com.qf.pojo.GoodsInfo;
import com.qf.pojo.SellerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SellerInfoMapper {
    /*
    查询所有
     */
    List<SellerInfo> listAllSellerInfo();

    /*
    数据总数
     */
    int count();

    /*
    分页数据查询
     */
    List<SellerInfo> page(Map<String,Object> para);

    /*
    根据id删除
     */
    int deleteSellerInfoById(int s_id);


    /*
    商店商品的总数和分页数据
     */
    int counts(int sellerId);

    List<GoodsInfo> pages(Map<String, Object> parms);

    /**
     * 商家信息录入
     * @param sellerInfo
     * @return
     */
    int insertSellerInfo(SellerInfo sellerInfo);

    /**
     * 根据id查询商家
     * @param sellerId
     * @return
     */
    SellerInfo getSellerInfoById(int sellerId);

    /**
     * 修改商家头像
     * @param sellerId
     * @param icon
     * @return
     */
    int updateIconBySellerId(@Param("sellerId") int sellerId,@Param("icon") String icon);

    /**
     * 修改商家信息
     * @param sellerInfo
     * @return
     */

    int updateSellerInfo(SellerInfo sellerInfo);
}
