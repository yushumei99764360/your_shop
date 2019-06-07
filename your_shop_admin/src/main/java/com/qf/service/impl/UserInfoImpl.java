package com.qf.service.impl;

import com.qf.dto.UserDetailInfo;
import com.qf.dto.UserInfoDto;
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
     * @param
     * @return
     */
    @Override
    public int insertUserInfo(UserInfoDto userInfoDto) {
        return userInfoMapper.insertUserInfo(userInfoDto);
    }

    /**
     * 批量删除
     * @param selectUsersId
     * @return
     */
    @Override
    public int deleteUsersInfo(List<Integer> selectUsersId) {
        return userInfoMapper.deleteUsersInfo(selectUsersId);
    }

    /**
     * 通过id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo getUserInfoById(int userId) {
        return userInfoMapper.getUserInfoById(userId);
    }

    @Override
    public int updateUserInfoById(UserInfo userInfo) {
        return userInfoMapper.updateUserInfoById(userInfo);
    }

    @Override
    public UserDetailInfo getUserDetailById(int userId) {
        return userInfoMapper.getUserDetailById(userId);
    }

}
