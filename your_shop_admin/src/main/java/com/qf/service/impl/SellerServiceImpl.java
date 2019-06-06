package com.qf.service.impl;

import com.qf.mapper.SellerInfoMapper;
import com.qf.pojo.SellerInfo;
import com.qf.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerInfoMapper sellerInfoMapper;

    @Override
    public List<SellerInfo> listAllSellerInfo() {

        return sellerInfoMapper.listAllSellerInfo();
    }

    @Override
    public int count() {
        return sellerInfoMapper.count();
    }

    @Override
    public List<SellerInfo> page(int start, int length) {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("start",start);
        parms.put("length",length);
        return sellerInfoMapper.page(parms);
    }
}
