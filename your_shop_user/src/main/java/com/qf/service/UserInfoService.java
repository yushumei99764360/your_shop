package com.qf.service;

import com.qf.vo.UserInfoLoginVo;

public interface UserInfoService {
    /**
     * 用户登录
     * @param userInfoLoginVo 用户名/密码/手机号/邮箱
     * @return
     */
    public Boolean userInfoLogin(UserInfoLoginVo userInfoLoginVo);
}
