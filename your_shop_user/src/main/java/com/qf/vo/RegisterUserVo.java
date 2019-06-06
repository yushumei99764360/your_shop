package com.qf.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterUserVo {
    String userName;
    String password;
    String phoneNumber;
    String email;
}
