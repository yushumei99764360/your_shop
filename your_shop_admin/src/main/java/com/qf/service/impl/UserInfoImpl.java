package com.qf.service.impl;

import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
