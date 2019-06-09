package com.qf.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoMessage {
    private Integer userId;
    private String userName;
    private String nickName;
    private String gender;
    private String age;
    private String icon;
    private String email;
    private String realName;
}
