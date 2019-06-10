package com.qf.mapper;

import com.qf.dto.UserInfoMessage;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoLoginVo;

import java.util.List;

public interface UserInfoMapper {
    /**
     * 登录
     * @param userInfoLoginVo 用户名/密码/手机号/邮箱
     * @return
     */
    public UserInfo userInfoLogin(UserInfoLoginVo userInfoLoginVo);

    /**
     * 根据用户id获取用户信息
     * @param userId    用户id
     * @return
     */
    public UserInfoMessage getUserInfoMessageById(int userId);
}
