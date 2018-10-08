package com.inspection.entity;

import java.util.Date;

public class JunShiJiaFen{
    private Date time;
    private String detail;
    public JunShiJiaFen(Date time, String detail) {
        this.time = time;
        this.detail = detail;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
