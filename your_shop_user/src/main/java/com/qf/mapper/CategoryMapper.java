package com.qf.mapper;


import com.qf.dto.*;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.vo.CategoryVo;

import java.util.List;

public interface CategoryMapper {

    /**
     * 商品分类
     * @return
     */
    // 查询所有一级类别信息
    List<Category> getFatherInfo();
    //    查询所有的二级类别信息
    List<Category> getChildInfo();
    // 根据父类id 查询它所包含的所有子类信息
    CategoryVo getChildCategoryInfo(int fatherId);

    public List<GoodsInfo> goods();

    public List<GoodsInfo> findAllCategory();

    GodsInfoDetail getGoodsInfoById(int g_id);

    AddressInfoDto searchAddress(int adsId);

    int insertOrder(AddressInfoDto addressInfoDto);

    GodsInfoDetail searchGoods(int g_id);

    int insertOrderDetail(Order_DetailDto order_detailDto);


    Logisticsinfo getlogistics(int g_id);
}
