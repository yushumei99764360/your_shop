package com.qf.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AddressInfo implements Serializable {
    int adsId;
    int userId;
    String province;
    String city;
    String district;
    String street;
}
