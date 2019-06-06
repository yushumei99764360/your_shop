package com.qf.service;

import com.qf.pojo.SellerInfo;

import java.util.List;

public interface SellerService {
    List<SellerInfo> listAllSellerInfo();

    int count();

    List<SellerInfo> page(int start, int length);
}
