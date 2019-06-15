package com.qf.dto;

import com.qf.pojo.Category;
import com.qf.pojo.GoodsInfo;
import lombok.Data;

import java.util.List;

@Data
public class FatherCategoryDto {
    /**
     * 父类菜单
     */
    private Integer c_id;
    private String c_name;
    private List<Category> categories;
}
