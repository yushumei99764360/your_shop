package com.qf.dto;

import com.qf.pojo.AddressInfo;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    int address;
    String express;
    int g_id;
    int num;

    int adsId;
    int userId;
    String province;
    String city;
    String district;
    String street;

    String shphone;
    String shname;
}
