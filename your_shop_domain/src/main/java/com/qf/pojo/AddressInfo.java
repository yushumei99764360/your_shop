package com.qf.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AddressInfo implements Serializable {
    /*
    CREATE TABLE `addressinfo` (
  `adsId` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(128) DEFAULT NULL,
  `city` varchar(128) DEFAULT NULL,
  `district` varchar(128) DEFAULT NULL,
  `street` varchar(128) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `shname` varchar(123) DEFAULT NULL,
  `shphone` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`adsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

     */
    int adsId;
    int userId;
    String province;
    String city;
    String district;
    String street;
    String shname;
    String shphone;
}
