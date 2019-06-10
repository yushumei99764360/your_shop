package com.qf.service.impl;

import com.qf.dto.UserInfoMessage;
import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo userInfoLogin(UserInfoLoginVo userInfoLoginVo) {
        return userInfoMapper.userInfoLogin(userInfoLoginVo);
    }

    @Override
    public UserInfoMessage getUserInfoMessageById(int userId) {
        return userInfoMapper.getUserInfoMessageById(userId);
    }
}
