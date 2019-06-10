package com.qf.service.impl;

import com.qf.mapper.AdminInfoMapper;
import com.qf.pojo.AdminInfo;
import com.qf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Override
    public int insertAdminInfo(AdminInfo adminInfo) {
        return adminInfoMapper.insertAdminInfo(adminInfo);
    }

    @Override
    public int count() {
        return adminInfoMapper.count();
    }

    @Override
    public List<AdminInfo> page(int start, int length) {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("start",start);
        parms.put("length",length);
        return adminInfoMapper.page(parms);
    }

    /**
     * 通过Id删除管理员
     * @param aid
     * @return
     */
    @Override
    public int deleteAdminInfoById(int aid) {
        return adminInfoMapper.deleteAdminInfoById(aid);
    }

    @Override
    public int deleteAdminInfo(List<Integer> selectAdminId) {
        return adminInfoMapper.deleteAdminInfo(selectAdminId);
    }

    /**
     * 通过Id查询管理员
     * @param aid
     * @return
     */
    @Override
    public AdminInfo getAdminInfoById(int aid) {
        return adminInfoMapper.getAdminInfoById(aid);
    }

    @Override
    public int updateAdminInfoById(AdminInfo adminInfo) {
        return adminInfoMapper.updateAdminInfoById(adminInfo);
    }
}
