package com.qf.mapper;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

import java.util.HashMap;
import java.util.List;

public interface UserInfoMapper {
    /**
     * 登录
     * @param userInfoVo 用户名/密码/手机号/邮箱
     * @return
     */
    public UserInfo userInfoLogin(UserInfoVo userInfoVo);

    /**
     * 根据用户id获取用户信息
     * @param userId    用户id
     * @return
     */
    public UserInfoMessageDto getUserInfoMessageById(int userId);

    /**
     * 根据用户id修改用户信息
     * @param userInfoMessage   用户信息
     * @return
     */
    public int updateUserInfo(UserInfoMessageDto userInfoMessageDto);

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

    int search(int userId);

    int insertUserDetail(UserInfoMessageDto userInfoMessage);


    /**
     * 修改头像
     * @param
     * @return
     */
    int updateIconByUserId(HashMap<String, Object> parms);


    List<AddressInfoDto> getUserInfoAddressById(int userId);

    int insertUserAddress(AddressInfoDto addressInfoDto);

    int deleteAddressByUserId(int adsId);
}
