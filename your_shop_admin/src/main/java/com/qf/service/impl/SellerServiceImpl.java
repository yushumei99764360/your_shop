package com.qf.service.impl;

import com.qf.mapper.SellerInfoMapper;
import com.qf.pojo.GoodsInfo;
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

    @Override
    public boolean deleteSellerInfoById(int s_id) {
        int i = sellerInfoMapper.deleteSellerInfoById(s_id);
        if (i != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int counts(int sellerId) {

        return sellerInfoMapper.counts(sellerId);
    }

    @Override
    public List<GoodsInfo> pages(int start, int length, int sellerId) {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("start",start);
        parms.put("length",length);
        parms.put("sellerId",sellerId);
        return sellerInfoMapper.pages(parms);

    }

    @Override
    public int insertSellerInfo(SellerInfo sellerInfo) {
        return sellerInfoMapper.insertSellerInfo(sellerInfo);
    }

    @Override
    public SellerInfo getSellerInfoById(int sellerId) {
        return sellerInfoMapper.getSellerInfoById(sellerId);
    }

    @Override
    public boolean updateIconBySellerId(int sellerId, String icon) {
        int i = sellerInfoMapper.updateIconBySellerId(sellerId, icon);
        if (i != 0) {
            return true;
        }
        return false;
    }

    /**
     * 修改商家信息
     * @param sellerInfo
     * @return
     */

    @Override
    public boolean updateSellerInfo(SellerInfo sellerInfo) {
        int i = sellerInfoMapper.updateSellerInfo(sellerInfo);
        if (i != 0) {
            return true;
        }
        return false;
    }

}
