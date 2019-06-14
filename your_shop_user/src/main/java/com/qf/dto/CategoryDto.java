package com.qf.dto;

import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    /**
     * 商品分类
     */
    private Integer c_id;
    private String c_name;
    //private int c_parentid;
    private String g_name;
    private Integer g_id;
    private List<Category> fatherCategory;
    private List<GoodsInfo> sonCategory;
}
