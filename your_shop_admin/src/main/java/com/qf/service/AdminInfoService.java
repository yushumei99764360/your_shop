package com.qf.service;

import com.qf.pojo.AdminInfo;

import java.util.List;

public interface AdminInfoService {

    int insertAdminInfo(AdminInfo adminInfo);

    int count();

    List<AdminInfo> page(int start, int length);

    int deleteAdminInfoById(int aid);

    int deleteAdminInfo(List<Integer> selectAdminId);

    AdminInfo getAdminInfoById(int aid);

    int updateAdminInfoById(AdminInfo adminInfo);

    int checkAdminName(String username);
}
