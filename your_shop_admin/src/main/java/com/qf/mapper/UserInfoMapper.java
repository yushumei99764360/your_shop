package com.qf.mapper;


import com.qf.dto.OrderInfoDto;
import com.qf.pojo.UserDetailInfo;
import com.qf.dto.UserInfoDto;

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


    int insertUserInfo(UserInfoDto userInfoDto);

    int deleteUsersInfo(List<Integer> selectUsersId);

    UserInfo getUserInfoById(int userId);

    int updateUserInfoById(UserInfo userInfo);


    UserDetailInfo getUserDetailById(int userId);

    int orderCount(int userId);

    List<OrderInfoDto> pageOrder(Map<String, Object> parms);

    int checkUserName();

}
