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
}
