package com.qf.service;

import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    AdminInfo adminLogin(AdminInfo adminInfo);

    List<UserInfo> listAllUserInfo();

    int deleteUserInfoById(int userId);

    int count();

    List<UserInfo> page(int start, int length);
}
