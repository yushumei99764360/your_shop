package com.qf.dto;

import com.qf.pojo.GoodsInfo;
import lombok.Data;

import java.util.List;

@Data
public class SonCategoryDto {
    private Integer c_id;
    private String c_name;
    private List<GoodsInfo> goodsInfoList;
}
