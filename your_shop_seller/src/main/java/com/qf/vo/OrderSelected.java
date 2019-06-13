package com.qf.vo;

import lombok.Data;

import java.util.Date;
@Data
public class OrderSelected {

    String str;

    String startTime;

    String endTime;

    String changeStartTime;

    String changeEndTime;

    String o_status;

    public OrderSelected() {
    }

    public OrderSelected(String str, String startTime, String endTime, String changeStartTime, String changeEndTime, String o_status) {
        this.str = str;
        this.startTime = startTime;
        this.endTime = endTime;
        this.changeStartTime = changeStartTime;
        this.changeEndTime = changeEndTime;
        this.o_status = o_status;
    }
}
