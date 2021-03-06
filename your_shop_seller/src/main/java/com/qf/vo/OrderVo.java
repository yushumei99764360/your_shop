package com.qf.vo;

import lombok.Data;

@Data
public class OrderVo {
//订单编号
  int id;
//    快递公司
    String o_sendtype;
//订单创建
   String o_orderdate;
//   订单修改
   String o_checkdate;
//    支付类型
    String o_paytype;
//    支付金额
    double o_paycount;
//下单人id
    int userId;
//    收货人
    String o_shperson;
//    收货人电话
    String o_shphone;
//    详细地址
    String o_shaddress;
//    省
    String o_province;
//    市
    String o_city;
//区
    String  o_district;




//卖家id
    int s_id;
//    详情订单创建日期
    String order_date;
    //   详情订单修改日期
    String order_modified;
//    订单id
    int o_orderid;
//    商品id
    int g_id;
//    商品名
    String g_name;
//    商品价格
    Double g_disctprice;
//    商品描述
    String g_desc;
//    商品数量
    int g_num;
//    订单总价
    Double g_total_price;
//    订单情况
String o_status;
//订单数量
int COUNT;

String allmoney;

String allcount;

String    allgoods;

    public OrderVo() {
    }

    public OrderVo(int id, String o_sendtype, String o_orderdate, String o_checkdate, String o_paytype, double o_paycount, int userId, String o_shperson, String o_shphone, String o_shaddress, String o_province, String o_city, String o_district, int s_id, String order_date, String order_modified, int o_orderid, int g_id, String g_name, Double g_disctprice, String g_desc, int g_num, Double g_total_price, String o_status, int COUNT, String allmoney, String allcount, String allgoods) {
        this.id = id;
        this.o_sendtype = o_sendtype;
        this.o_orderdate = o_orderdate;
        this.o_checkdate = o_checkdate;
        this.o_paytype = o_paytype;
        this.o_paycount = o_paycount;
        this.userId = userId;
        this.o_shperson = o_shperson;
        this.o_shphone = o_shphone;
        this.o_shaddress = o_shaddress;
        this.o_province = o_province;
        this.o_city = o_city;
        this.o_district = o_district;
        this.s_id = s_id;
        this.order_date = order_date;
        this.order_modified = order_modified;
        this.o_orderid = o_orderid;
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_disctprice = g_disctprice;
        this.g_desc = g_desc;
        this.g_num = g_num;
        this.g_total_price = g_total_price;
        this.o_status = o_status;
        this.COUNT = COUNT;
        this.allmoney = allmoney;
        this.allcount = allcount;
        this.allgoods = allgoods;
    }
}

