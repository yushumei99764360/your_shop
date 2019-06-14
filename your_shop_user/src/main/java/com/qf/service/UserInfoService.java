package com.qf.service;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.MessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.pojo.AddressInfo;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

import java.util.List;

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
    public UserInfoMessageDto getUserInfoMessageById(int userId);

    /**
     * 根据用户id修改用户信息
     * @param userInfoMessageDto   用户信息
     * @return
     */
    public int updateUserInfo(UserInfoMessageDto userInfoMessageDto);

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

    int insertUserDetail(UserInfoMessageDto userInfoMessage);

    boolean updateIconByUserId(int userId, String icon);


    List<AddressInfoDto> getUserInfoAddressById(int userId);

    Object insertUserAddress(AddressInfoDto addressInfoDto);

    int deleteAddressByUserId(int adsId);

    List<MessageDto> selectUserByMessage(int g_id);

    int insertMessageByGoods(MessageDto messageDto);

    Object selectSellPic(int g_id);
}
