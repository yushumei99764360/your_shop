package com.qf.mapper;

import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoLoginVo;

import java.util.List;

public interface UserInfoLoginMapper {
    /**
     * 登录
     * @param userInfoLoginVo 用户名/密码/手机号/邮箱
     * @return
     */
    public List<UserInfo> userInfoLogin(UserInfoLoginVo userInfoLoginVo);

}
