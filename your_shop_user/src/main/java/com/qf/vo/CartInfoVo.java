package com.qf.vo;

import lombok.Data;

@Data
public class CartInfoVo {

    int userId;
    String g_pic;
    int g_id;
    int product_amount;
    double g_disctprice;
    double sum_price;
    String g_name;
    String s_name;

}
