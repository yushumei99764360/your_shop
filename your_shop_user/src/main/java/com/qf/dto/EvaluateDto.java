package com.qf.dto;

import lombok.Data;

@Data
public class EvaluateDto {

    String g_name;
    String g_price;
    String g_pic;
    String g_desc;
    String s_name;
    String icon;

    public EvaluateDto() {
    }

    public EvaluateDto(String g_name, String g_price, String g_pic, String g_desc, String s_name, String icon) {
        this.g_name = g_name;
        this.g_price = g_price;
        this.g_pic = g_pic;
        this.g_desc = g_desc;
        this.s_name = s_name;
        this.icon = icon;
    }
}
