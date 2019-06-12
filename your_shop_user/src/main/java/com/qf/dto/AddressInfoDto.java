package com.qf.dto;

import lombok.Data;

@Data
public class AddressInfoDto {
    int adsId;
    int userId;
    String province;
    String city;
    String district;
    String street;
    String shphone;
    String shname;
}
