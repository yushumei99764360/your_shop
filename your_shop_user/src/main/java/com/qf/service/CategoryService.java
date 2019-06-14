package com.qf.service;


import com.qf.dto.AddressInfoDto;
import com.qf.dto.CategoryDto;
import com.qf.dto.GodsInfoDetail;
import com.qf.dto.Order_DetailDto;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.vo.CategoryVo;


import java.util.List;

public interface CategoryService {
    /**
     * 商品分类
     * @return
     */
    public List<GoodsInfo> goods();

    // 查询所有一级类别信息
    List<Category> getFatherInfo();

    //    查询所有的二级类别信息
    List<Category> getChildInfo();

    // 根据父类id 查询它所包含的所有子类信息
    CategoryVo getChildCategoryInfo(int fatherId);

    public List<GoodsInfo> findAllCategory();

    GodsInfoDetail getGoodsInfoById(int g_id);

    AddressInfoDto searchAddress(int adsId);

    int insertOrder(AddressInfoDto addressInfoDto);

    int insertOrderDetail( Order_DetailDto order_detailDto);

    GodsInfoDetail searchGoods(int g_id);

}
