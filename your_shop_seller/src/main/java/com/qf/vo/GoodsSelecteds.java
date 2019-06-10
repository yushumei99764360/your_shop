package com.qf.vo;

import java.util.Date;

public class GoodsSelecteds {
//    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表

    String categoryName;
    String str;
    int g_status;
    Date minDate;
    Date maxDate;

    @Override
    public String toString() {
        return "GoodsSelecteds{" +
                "categoryName='" + categoryName + '\'' +
                ", str='" + str + '\'' +
                ", g_status=" + g_status +
                ", minDate=" + minDate +
                ", maxDate=" + maxDate +
                '}';
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

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }
}
