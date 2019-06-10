package com.qf.mapper;

import com.qf.pojo.AdminInfo;

import java.util.List;
import java.util.Map;

public interface AdminInfoMapper {
    int insertAdminInfo(AdminInfo adminInfo);

    int count();

    List<AdminInfo> page(Map<String, Object> parms);

    int deleteAdminInfoById(int aid);

    int deleteAdminInfo(List<Integer> selectAdminId);

    AdminInfo getAdminInfoById(int aid);

    int updateAdminInfoById(AdminInfo adminInfo);
}
