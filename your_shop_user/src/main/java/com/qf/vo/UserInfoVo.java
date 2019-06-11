package com.qf.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVo {
    private Integer userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
}
