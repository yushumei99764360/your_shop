package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Order_Detail implements Serializable {
    /*
    CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL COMMENT '订单创建日期',
  `o_orderid` int(11) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL COMMENT '商品id',
  `g_name` varchar(20) DEFAULT NULL COMMENT '商品名',
  `g_disctprice` double(20,2) DEFAULT NULL COMMENT '商品价格',
  `g_desc` varchar(100) DEFAULT NULL COMMENT '商品描述',
  `g_num` int(20) DEFAULT NULL COMMENT '商品数量',
  `g_total_price` double(20,2) DEFAULT NULL COMMENT '订单总价',
  `order_modified` date DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `FK_ORDER` (`o_orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8


     */

     int id;
     Date order_date;
     int o_orderid;
     int g_id;
     String g_name;
     double g_disctprice;
     String  g_desc;
     int g_num;
     double g_total_price;
     String g_pic;
     Date order_modified;

}
