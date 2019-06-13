package com.qf.vo;

import java.util.Date;

public class SellerVo {

//    店家id
    int s_id;
//    店家编码
    String s_code;
//    店家名称
    String s_name;
//    店家密码
    String s_pwd;
//    店家联系电话
    String s_phone;
//    店家地址
    String s_address;
//    店家描述
    String s_desc;
//    店家状态
    String s_status;
//    开店时间
    String s_date;
//    最后修改时间
    String s_lastdate;
    //商家图片
    String icon;

    @Override
    public String toString() {
        return "SellerVo{" +
                "s_id=" + s_id +
                ", s_code='" + s_code + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_pwd='" + s_pwd + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_address='" + s_address + '\'' +
                ", s_desc='" + s_desc + '\'' +
                ", s_status='" + s_status + '\'' +
                ", s_date='" + s_date + '\'' +
                ", s_lastdate='" + s_lastdate + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_pwd() {
        return s_pwd;
    }

    public void setS_pwd(String s_pwd) {
        this.s_pwd = s_pwd;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public String getS_lastdate() {
        return s_lastdate;
    }

    public void setS_lastdate(String s_lastdate) {
        this.s_lastdate = s_lastdate;
    }
}
