package com.qf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class  UserInfo implements Serializable {
   int  userId;
   String userName;
   String password;
   String phoneNumber;
   String email;
   int flag;
   int checkState;

   @Override
   public String toString() {
      return "UserInfo{" +
              "userId=" + userId +
              ", userName='" + userName + '\'' +
              ", password='" + password + '\'' +
              ", phoneNumber='" + phoneNumber + '\'' +
              ", email='" + email + '\'' +
              ", flag=" + flag +
              ", checkState=" + checkState +
              '}';
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getFlag() {
      return flag;
   }

   public void setFlag(int flag) {
      this.flag = flag;
   }

   public int getCheckState() {
      return checkState;
   }

   public void setCheckState(int checkState) {
      this.checkState = checkState;
   }
}
