package com.qf.vo;


import java.util.Date;

public class GoodsVo {

    //商品id
    int g_id;
    //    商品编码
    String g_core;
    //商品品牌
    String g_title;
    //商品名称
    String g_name;
    //销售价格
    double g_price;
    //    商品折扣
    double g_discount;
    //折扣价
    double g_disctprice;
    //库存数量
    int g_num;
    //商品描述
    String g_desc;
    //    商品照片
    String g_pic;
    //是否上架 1是 0不是
    String g_status ;
    // 商品录入时间
    String g_date;
    //    商品最后修改时间
    String g_lastdate;
    // 商店id
    int s_id;
//    商品子类
    String childName;
    // 商品父类
    String fatherName;

    @Override
    public String toString() {
        return "GoodsVo{" +
                "g_id=" + g_id +
                ", g_core='" + g_core + '\'' +
                ", g_title='" + g_title + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_discount=" + g_discount +
                ", g_disctprice=" + g_disctprice +
                ", g_num=" + g_num +
                ", g_desc='" + g_desc + '\'' +
                ", g_pic='" + g_pic + '\'' +
                ", g_status=" + g_status +
                ", g_date=" + g_date +
                ", g_lastdate=" + g_lastdate +
                ", s_id=" + s_id +
                ", childName='" + childName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_core() {
        return g_core;
    }

    public void setG_core(String g_core) {
        this.g_core = g_core;
    }

    public String getG_title() {
        return g_title;
    }

    public void setG_title(String g_title) {
        this.g_title = g_title;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public double getG_discount() {
        return g_discount;
    }

    public void setG_discount(double g_discount) {
        this.g_discount = g_discount;
    }

    public double getG_disctprice() {
        return g_disctprice;
    }

    public void setG_disctprice(double g_disctprice) {
        this.g_disctprice = g_disctprice;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public String getG_desc() {
        return g_desc;
    }

    public void setG_desc(String g_desc) {
        this.g_desc = g_desc;
    }

    public String getG_pic() {
        return g_pic;
    }

    public void setG_pic(String g_pic) {
        this.g_pic = g_pic;
    }

    public String getG_status() {
        return g_status;
    }

    public void setG_status(String g_status) {
        this.g_status = g_status;
    }

    public String getG_date() {
        return g_date;
    }

    public void setG_date(String g_date) {
        this.g_date = g_date;
    }

    public String getG_lastdate() {
        return g_lastdate;
    }

    public void setG_lastdate(String g_lastdate) {
        this.g_lastdate = g_lastdate;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
