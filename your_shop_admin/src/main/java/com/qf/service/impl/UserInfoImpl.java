package com.qf.service.impl;

import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 管理员登录
     * @param
     * @return
     */
    @Override
    public AdminInfo adminLogin(AdminInfo adminInfo) {
        return userInfoMapper.adminLogin(adminInfo);
    }

    /**
     * 管理员查询用户
     * @return
     */
    @Override
    public List<UserInfo> listAllUserInfo() {
        return userInfoMapper.listAllUserInfo();
    }

    /**
     * 通过Id删除用户
     * @param userId
     * @return
     */
    @Override
    public int deleteUserInfoById(int userId) {
        return userInfoMapper.deleteUserInfoById(userId);
    }

    @Override
    public int count() {
        return userInfoMapper.count();
    }

    public List<UserInfo> page(int start, int length ) {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("start",start);
        parms.put("length",length);
        return userInfoMapper.page(parms);
    }

    /**
     * 添加会员
     * @param userInfo
     * @return
     */
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }
}
