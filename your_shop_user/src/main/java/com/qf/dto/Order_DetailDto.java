package com.qf.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class Order_DetailDto implements Serializable {
    /*
    od.`g_disctprice`,od.`g_id`,od.`g_name`,od.`g_num`,od.`g_pic`,od.`g_total_price`,od.`id` odid
     */
    public int id;

    public int g_id;
    public String g_name;
    public double g_disctprice;

    public int g_num;
    public double g_total_price;
    public String g_pic;


}
