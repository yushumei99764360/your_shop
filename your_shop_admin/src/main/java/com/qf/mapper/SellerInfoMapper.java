package com.qf.mapper;

import com.qf.pojo.SellerInfo;

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
}
