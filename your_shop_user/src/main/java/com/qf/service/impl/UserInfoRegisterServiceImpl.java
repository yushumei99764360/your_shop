package com.qf.service.impl;

import com.qf.mapper.UserInfoRegisterMapper;
import com.qf.service.UserInfoService2;
import com.qf.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoRegisterServiceImpl implements UserInfoService2 {
    @Autowired
    UserInfoRegisterMapper registerMapper;

    @Override
    public Boolean RegisterUserInfo(RegisterUserVo registerUserVo) {
        Integer count = registerMapper.RegisterUserInfo(registerUserVo);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public Integer checkUserName(String userName) {
        return registerMapper.checkUserName(userName);
    }
}
