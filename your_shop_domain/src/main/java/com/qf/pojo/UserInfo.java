package com.qf.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
   int  userId;
   @Length
   String userName;
   String password;
   String phoneNumber;
   String email;
   int flag;
   int checkState;
}
