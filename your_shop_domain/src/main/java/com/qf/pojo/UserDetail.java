package com.qf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDetail implements Serializable {
    int udeId;
    String nickName;
    String gender;
    String birthday;
    String icon;
}
