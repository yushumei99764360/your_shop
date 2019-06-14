package com.qf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartInfo  {
    /*
    CREATE TABLE `cartinfo` (
  `cart_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `userId` int(10) unsigned NOT NULL COMMENT '用户ID',
  `g_pic` varchar(128) DEFAULT NULL COMMENT '商品图片',
  `g_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  `product_amount` int(11) NOT NULL COMMENT '加入购物车商品数量',
  `g_disctprice` decimal(8,2) NOT NULL COMMENT '商品价格',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入购物车时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `sum_price` decimal(8,2) DEFAULT NULL COMMENT '金额小计 数量 * 价格',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表'

     */

    int cart_id;
    int userId;
    String g_pic;
    String g_name;
    String s_name;
    int g_id;
    int product_amount;
    double g_disctprice;
    double sum_price;


}
