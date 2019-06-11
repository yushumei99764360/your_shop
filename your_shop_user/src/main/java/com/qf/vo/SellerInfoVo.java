package com.qf.vo;

import lombok.Data;

@Data
public class SellerInfoVo {
    private Integer s_id;
    private String s_code;
    private String s_name;
    private String s_pwd;
    private String s_phone;
    private String s_address;
    private String s_desc;
    private Integer s_status;

    public Integer getS_status() {
        return s_status;
    }

    public void setS_status(Integer s_status) {
        this.s_status = s_status;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
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

    @Override
    public String toString() {
        return "SellerInfoVo{" +
                "s_id=" + s_id +
                ", s_code='" + s_code + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_pwd='" + s_pwd + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_address='" + s_address + '\'' +
                ", s_desc='" + s_desc + '\'' +
                ", s_status=" + s_status +
                '}';
    }
}
