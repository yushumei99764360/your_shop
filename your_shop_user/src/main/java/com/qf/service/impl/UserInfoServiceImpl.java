package com.qf.service.impl;

import com.qf.dto.UserInfoMessage;
import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo userInfoLogin(UserInfoVo userInfoVo) {
        return userInfoMapper.userInfoLogin(userInfoVo);
    }

    @Override
    public UserInfoMessage getUserInfoMessageById(int userId) {
        return userInfoMapper.getUserInfoMessageById(userId);
    }

    /**
     * 修改添加
     * @param userInfoMessage   用户信息
     * @return
     */
    @Override
    public int updateUserInfo(UserInfoMessage userInfoMessage) {
        return userInfoMapper.updateUserInfo(userInfoMessage);
    }

    @Override
    public Boolean RegisterUserInfo(UserInfoVo userInfoVo) {
        Integer count = userInfoMapper.RegisterUserInfo(userInfoVo);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public Integer checkUserName(String userName) {
        return userInfoMapper.checkUserName(userName);
    }

    /**
     * 查看用户详细信息是否填写
     * @param userId
     * @return
     */
    @Override
    public int search(int userId) {
        return userInfoMapper.search(userId);
    }

    /**
     * 用户详细信息添加
     * @param userInfoMessage
     * @return
     */
    @Override
    public int insertUserDetail(UserInfoMessage userInfoMessage) {
        return userInfoMapper.insertUserDetail(userInfoMessage);
    }

    @Override
    public boolean updateIconByUserId(int userId, String icon) {
        int i = userInfoMapper.updateIconByUserId(userId, icon);
        if (i != 0) {
            return true;
        }
        return false;
    }
}
