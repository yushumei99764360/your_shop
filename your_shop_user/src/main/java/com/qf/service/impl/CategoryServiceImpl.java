package com.qf.service.impl;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.CategoryDto;
import com.qf.dto.CreateOrderDto;
import com.qf.dto.GodsInfoDetail;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;



    @Override
    public List<CategoryDto> categoryList() {
        //System.out.println(3);
        return categoryMapper.categoryList();
    }


    @Override
    public List<CategoryDto> categoryListOne() {
        System.out.println(2);
        return categoryMapper.categoryListOne();
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
}
