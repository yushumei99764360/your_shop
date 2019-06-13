package com.qf.service.impl;

import com.qf.dto.*;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<CategoryDto> categoryList() {
        return null;
    }

    @Override
    public List<CategoryDto> categoryListOne() {
        return null;
    }

    /**
     * 商品信息查询
     * @param g_id
     * @return
     */
    @Override
    public GodsInfoDetail getGoodsInfoById(int g_id) {
        return categoryMapper.getGoodsInfoById(g_id);
    }

    /**
     * 查询用户选择的收货地址
     * @param adsId
     * @return
     */
    @Override
    public AddressInfoDto searchAddress(int adsId) {
        return categoryMapper.searchAddress(adsId);
    }

    @Override
    public int insertOrder(AddressInfoDto addressInfoDto) {
        return categoryMapper.insertOrder(addressInfoDto);
    }

    @Override
    public int insertOrderDetail( Order_DetailDto order_detailDto) {
        return categoryMapper.insertOrderDetail(order_detailDto);
    }

    /**
     *
     * 获取商品信息
     * @param g_id
     * @return
     */
    @Override
    public GodsInfoDetail searchGoods(int g_id) {
        return categoryMapper.searchGoods(g_id);
    }
}
