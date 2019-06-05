package com.qf.service.impl;

import com.qf.mapper.UserInfoLoginMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoLoginMapper userInfoLoginMapper;

    @Override
    public Boolean userInfoLogin(UserInfoLoginVo userInfoLoginVo) {
        List<UserInfo> userInfos = userInfoLoginMapper.userInfoLogin(userInfoLoginVo);
        if (userInfos != null && userInfos.size() > 0) {
            return true;
        }
        return false;
    }
}
