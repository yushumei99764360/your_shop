package com.qf.vo;

import lombok.Data;

@Data
public class RefundVo {
   int r_orderid;
    String r_reason;
    String  r_pic;
    String r_type;
    String  r_return;
    String r_remoney;

    public RefundVo() {
    }

    public RefundVo(int r_orderid, String r_reason, String r_pic, String r_type, String r_return, String r_remoney) {
        this.r_orderid = r_orderid;
        this.r_reason = r_reason;
        this.r_pic = r_pic;
        this.r_type = r_type;
        this.r_return = r_return;
        this.r_remoney = r_remoney;
    }
}
