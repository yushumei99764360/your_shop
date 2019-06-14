package com.qf.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InsertOrderDto implements Serializable {
    /*
     "o_sendtype":express,
                "adsId":address,
                "o_paycount":totalPayPrice
     */

    String o_sendtype;
    int adsId;
    int o_paycount;
}
