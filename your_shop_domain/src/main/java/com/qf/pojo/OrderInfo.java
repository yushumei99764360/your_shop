package com.qf.pojo;

import lombok.Data;

@Data
public class OrderInfo {
    /*
    CREATE TABLE `orderinfo` (
  `id` int(11) NOT NULL,
  `o_sendtype` varchar(20) DEFAULT NULL COMMENT '快递公司',
  `o_paytype` varchar(20) DEFAULT NULL COMMENT '支付类型',
  `o_paycount` double(20,2) DEFAULT NULL COMMENT '支付金额',
  `userId` int(11) DEFAULT NULL,
  `o_shperson` varchar(20) DEFAULT NULL COMMENT '收货人',
  `o_shphone` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  `o_shaddress` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `o_province` varchar(20) DEFAULT NULL COMMENT '省',
  `o_city` varchar(20) DEFAULT NULL COMMENT '市',
  `o_district` varchar(20) DEFAULT NULL COMMENT '区',
  `s_id` int(11) DEFAULT NULL COMMENT '卖家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


     */
    private int id;
    private String o_sendtype;
    private String o_paytype;
    private double o_paycount;
    private int userId;
    private String o_shperson;
    private String o_shphone;
    private String o_shaddress;
    private String o_province;
    private String o_city;
    private String o_district;
    private int s_id;

}
