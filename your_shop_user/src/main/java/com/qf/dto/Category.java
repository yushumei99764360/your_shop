package com.qf.dto;

import lombok.Data;

@Data
public class Category {
    /**
     * 商品分类
     */
    private int cid;
    private String cname;
    private int parentId;
}
