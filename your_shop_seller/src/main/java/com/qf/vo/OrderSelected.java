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

    public OrderSelected() {
    }

    public OrderSelected(String str, String startTime, String endTime, String changeStartTime, String changeEndTime) {
        this.str = str;
        this.startTime = startTime;
        this.endTime = endTime;
        this.changeStartTime = changeStartTime;
        this.changeEndTime = changeEndTime;
    }
}
