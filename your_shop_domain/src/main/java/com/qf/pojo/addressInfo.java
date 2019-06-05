package com.qf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class addressInfo implements Serializable {
    int adsId;
    String province;
    String city;
    String district;
    String street;
}
