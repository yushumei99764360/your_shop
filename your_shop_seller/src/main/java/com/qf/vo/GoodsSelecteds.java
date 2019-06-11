package com.qf.vo;

import java.util.Date;

public class GoodsSelecteds {
//    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表

    int sellerId;
    String categoryName;
    String str;
    int g_status;
    String minDate;
    String maxDate;

    @Override
    public String toString() {
        return "GoodsSelecteds{" +
                "sellerId=" + sellerId +
                ", categoryName='" + categoryName + '\'' +
                ", str='" + str + '\'' +
                ", g_status=" + g_status +
                ", minDate='" + minDate + '\'' +
                ", maxDate='" + maxDate + '\'' +
                '}';
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getG_status() {
        return g_status;
    }

    public void setG_status(int g_status) {
        this.g_status = g_status;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }
}
