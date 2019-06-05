package com.qf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
   int  userId;
   String userName;
   String password;
   String phoneNumber;
   String email;
   int flag;
   int checkState;
}
