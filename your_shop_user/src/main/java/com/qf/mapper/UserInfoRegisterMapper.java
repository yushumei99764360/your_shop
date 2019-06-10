package com.qf.mapper;

import com.qf.vo.RegisterUserVo;

public interface UserInfoRegisterMapper {
    public Integer RegisterUserInfo(RegisterUserVo registerUserVo);
    public Integer checkUserName(String userName);
}
