package com.qf.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class GoodsInfo {
    //商品id
    int g_id;
//    商品编码
    String g_core;
    //商品品牌
    String g_title;
    //商品名称
    String g_name;
    //销售价格
    double g_price;
//    商品折扣
    double g_discount;
    //折扣价
    double g_disctprice;
    //库存数量
    int g_num;
    //商品描述
    String g_desc;
//    商品照片
    String g_pic;
    //是否上架 1是 0不是
    int g_status = 1;
    // 商品录入时间
    Date g_date;
//    商品最后修改时间
    Date g_lastdate;
    // 商店id
    int s_id;

}
