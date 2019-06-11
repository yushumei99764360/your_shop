package com.qf.mapper;

import com.qf.dto.UserInfoMessage;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

public interface UserInfoMapper {
    /**
     * 登录
     * @param userInfoLoginVo 用户名/密码/手机号/邮箱
     * @return
     */
    public UserInfo userInfoLogin(UserInfoVo userInfoVo);

    /**
     * 根据用户id获取用户信息
     * @param userId    用户id
     * @return
     */
    public UserInfoMessage getUserInfoMessageById(int userId);

    /**
     * 根据用户id修改用户信息
     * @param userInfoMessage   用户信息
     * @return
     */
    public int updateUserInfo(UserInfoMessage userInfoMessage);

    /**
     * 注册用户
     * @param userInfoVo    用户信息
     * @return
     */
    public Integer RegisterUserInfo(UserInfoVo userInfoVo);

    /**
     * 判断用户名是否存在
     * @param userName  用户名
     * @return
     */
    public Integer checkUserName(String userName);
}
