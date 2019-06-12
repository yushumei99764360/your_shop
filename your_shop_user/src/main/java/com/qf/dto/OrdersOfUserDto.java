package com.qf.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qf.pojo.Order_Detail;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户订单对象，包含 订单详情的集合
 */
@Data
public class OrdersOfUserDto implements Serializable {

    /*
    o_orderdate  timestamp     (NULL)           YES             CURRENT_TIMESTAMP          select,insert,update,references  创建日期
o_checkdate  timestamp     (NULL)           YES             CURRENT_TIMESTAMP          select,insert,update,references  修改日期
o_status
     */
    public int id;
    public String o_sendtype;
    public String o_paytype;
    public double o_paycount;
    public int userId;
    public String o_shperson;
    public String o_shphone;
    public String o_shaddress;
    public String o_province;
    public String o_city;
    public String o_district;
    public int s_id;
    public Date o_orderdate;
    public Date o_checkdate;
    public int o_status;
    public List<Order_DetailDto> order_details;
}
