package com.qf.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private Integer userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
}
