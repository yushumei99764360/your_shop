package com.qf.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Pattern;

@Data
public class UserInfoDto {
    @Length(min= 2,max = 20,message = "用户名不合法")
    String username;
    @Length(min = 2)
    String password;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱地址不合法")
    String email;
    @Length(min = 11,message = "手机号错误")
    String phonenumber;
}
