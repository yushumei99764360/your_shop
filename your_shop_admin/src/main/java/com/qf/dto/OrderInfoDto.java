package com.qf.dto;

import lombok.Data;

@Data
public class OrderInfoDto {
    int userId;
    String o_shperson;
    String o_shaddress;
    String o_province;
    String o_city;
    String o_district;
    String g_name;
    String order_date;
    Double g_total_price;
    int o_orderid;
}
