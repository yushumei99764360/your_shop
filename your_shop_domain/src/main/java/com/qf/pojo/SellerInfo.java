package com.qf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SellerInfo {
    /*
    CREATE TABLE `sellerinfo` (
  `s_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '店家ID',
  `s_code` varchar(18) DEFAULT NULL COMMENT '店家编码',
  `s_name` varchar(50) NOT NULL COMMENT '店家名称',
  `s_pwd` varchar(50) NOT NULL COMMENT '店家密码',
  `s_phone` varchar(50) NOT NULL COMMENT '店家联系电话',
  `s_address` varchar(200) NOT NULL COMMENT '店家地址',
  `s_desc` varchar(255) DEFAULT NULL COMMENT '店家描述',
  `s_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0禁止，1启用',
  `s_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '店家开店时间',
  `g_lastdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='店家信息表'

     */
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
}
