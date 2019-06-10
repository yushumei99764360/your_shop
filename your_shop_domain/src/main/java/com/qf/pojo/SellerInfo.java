package com.qf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SellerInfo {
    int s_id;
    String s_code;
    String s_name;
    String s_pwd;
    String s_phone;
    String s_address;
    String s_desc;
    int s_status;
    Date s_date;
    Date g_lastdate;
    String icon;

}
