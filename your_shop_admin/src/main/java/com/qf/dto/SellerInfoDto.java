package com.qf.dto;

import java.util.Date;

public class SellerInfoDto {

    int s_id;
    String s_code;
    String s_name;
    String s_pwd;
    String s_phone;
    String s_address;
    String s_desc;
    String s_status;
    Date s_date;
    Date g_lastdate;
    String icon;



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SellerInfoDto() {
    }

    public SellerInfoDto(int s_id, String s_code, String s_name, String s_pwd, String s_phone, String s_address, String s_desc, String s_status, Date s_date, Date g_lastdate) {
        this.s_id = s_id;
        this.s_code = s_code;
        this.s_name = s_name;
        this.s_pwd = s_pwd;
        this.s_phone = s_phone;
        this.s_address = s_address;
        this.s_desc = s_desc;
        this.s_status = s_status;
        this.s_date = s_date;
        this.g_lastdate = g_lastdate;
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

    public void setS_status(int s_status) {
        if (s_status == 0) {
            this.s_status = "下线";
        } else {
            this.s_status = "上线";
        }

    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public Date getG_lastdate() {
        return g_lastdate;
    }

    public void setG_lastdate(Date g_lastdate) {
        this.g_lastdate = g_lastdate;
    }

    @Override
    public String toString() {
        return "SellerInfoDto{" +
                "s_id=" + s_id +
                ", s_code='" + s_code + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_pwd='" + s_pwd + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_address='" + s_address + '\'' +
                ", s_desc='" + s_desc + '\'' +
                ", s_status='" + s_status + '\'' +
                ", s_date=" + s_date +
                ", g_lastdate=" + g_lastdate +
                ", icon='" + icon + '\'' +
                '}';
    }
}
