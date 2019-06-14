package com.qf.service.impl;

import com.qf.dto.AddressInfoDto;
import com.qf.dto.MessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.dto.UserInfoMessageDto;
import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo userInfoLogin(UserInfoVo userInfoVo) {
        return userInfoMapper.userInfoLogin(userInfoVo);
    }

    @Override
    public UserInfoMessageDto getUserInfoMessageById(int userId) {
        return userInfoMapper.getUserInfoMessageById(userId);
    }

    /**
     * 修改添加
     * @param userInfoMessageDto   用户信息
     * @return
     */
    @Override
    public int updateUserInfo(UserInfoMessageDto userInfoMessageDto) {
        return userInfoMapper.updateUserInfo(userInfoMessageDto);
    }

    @Override
    public Boolean RegisterUserInfo(UserInfoVo userInfoVo) {
        Integer count = userInfoMapper.RegisterUserInfo(userInfoVo);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public Integer checkUserName(String userName) {
        return userInfoMapper.checkUserName(userName);
    }

    /**
     * 查看用户详细信息是否填写
     * @param userId
     * @return
     */
    @Override
    public int search(int userId) {
        return userInfoMapper.search(userId);
    }

    /**
     * 用户详细信息添加
     * @param userInfoMessageDto
     * @return
     */
    @Override
    public int insertUserDetail(UserInfoMessageDto userInfoMessageDto) {
        return userInfoMapper.insertUserDetail(userInfoMessageDto);
    }

    /**
     * 个人头像修改
     * @param userId
     * @param icon
     * @return
     */
    @Override
    public boolean updateIconByUserId(int userId, String icon) {
        HashMap<String, Object> parms = new HashMap<>();
        parms.put("userId",userId);
        parms.put("icon",icon);
        int i = userInfoMapper.updateIconByUserId(parms);
        if (i != 0) {
            return true;
        }
        return false;
    }

    /**
     * 地址查询
     * @param
     * @return
     */
    @Override
    public List<AddressInfoDto> getUserInfoAddressById(int userId) {
        return userInfoMapper.getUserInfoAddressById(userId);
    }

    /**
     * 添加收货地址
     * @param addressInfoDto
     * @return
     */
    @Override
    public Object insertUserAddress(AddressInfoDto addressInfoDto) {
        int i= userInfoMapper.insertUserAddress(addressInfoDto);
        if (i!=0){
            return true;
        }
        return false;
    }

    /**
     * 删除收货地址
     * @param adsId
     * @return
     */
    @Override
    public int deleteAddressByUserId(int adsId) {
        return userInfoMapper.deleteAddressByUserId(adsId);
    }

    @Override
    public List<MessageDto> selectUserByMessage(int g_id) {
        return userInfoMapper.selectUserByMessage(g_id);
    }


//    增加留言
    @Override
    public int insertMessageByGoods(MessageDto messageDto) {
        return userInfoMapper.insertMessageByGoods(messageDto);
    }

    @Override
    public Object selectSellPic(int g_id) {
        return userInfoMapper.selectSellPic(g_id);
    }
}
