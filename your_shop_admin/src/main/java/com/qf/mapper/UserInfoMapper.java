package com.qf.mapper;

import com.qf.pojo.AdminInfo;
import com.qf.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    AdminInfo adminLogin(AdminInfo adminInfo);

    List<UserInfo> listAllUserInfo();

    int deleteUserInfoById(int userId);

    List<UserInfo> page(Map<String, Object> parms);

    int count();

}
