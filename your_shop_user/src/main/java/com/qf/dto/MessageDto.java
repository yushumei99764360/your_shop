package com.qf.dto;

import lombok.Data;

@Data
public class MessageDto {
//    留言
    String context;
//昵称
    String nickName;
//    性别
    String gender;
//    用户头头像
    String icon;
//    商品id
    int g_id;
//    留言
    String message;
//用户id
    int userId;

    public MessageDto() {
    }

    public MessageDto(String context, String nickName, String gender, String icon, int g_id, String message, int userId) {
        this.context = context;
        this.nickName = nickName;
        this.gender = gender;
        this.icon = icon;
        this.g_id = g_id;
        this.message = message;
        this.userId = userId;
    }
}
