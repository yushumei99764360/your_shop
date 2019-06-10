package com.qf.service;

import com.qf.vo.RegisterUserVo;

public interface UserInfoService2 {
    /**
     *  用户注册
     * @param registerUserVo
     * @return
     */
    public Boolean RegisterUserInfo(RegisterUserVo registerUserVo);
    public Integer checkUserName(String userName);
}
