package com.qf.service;

import com.qf.dto.UserInfoMessage;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

public interface UserInfoService {
    /**
     * 用户登录
     * @param  userInfoVo 用户名/密码/手机号/邮箱
     * @return
     */
    public UserInfo userInfoLogin(UserInfoVo userInfoVo);

    /**
     * 根据id获取用户信息
     * @param userId 用户id
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
     *  用户注册
     * @param userInfoVo
     * @return
     */
    public Boolean RegisterUserInfo(UserInfoVo userInfoVo);

    /**
     * 判断用户名是否存在
     * @param userName  用户名
     * @return
     */
    public Integer checkUserName(String userName);

    int search(int userId);

    int insertUserDetail(UserInfoMessage userInfoMessage);

    boolean updateIconByUserId(int userId, String icon);
}
