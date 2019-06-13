package com.qf.dto;

import com.qf.pojo.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    /**
     * 商品分类
     */
    private int c_id;
    private String c_name;
    private String c_parentid;
}
