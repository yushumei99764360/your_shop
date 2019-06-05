package com.qf.service;

import com.qf.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo adminLogin(UserInfo userInfo);
    List<UserInfo> u();

}
