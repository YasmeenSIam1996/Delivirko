package com.ict.delivirko.Module.restaurant;

import java.util.List;

public class OrderData {
    private String end_date;
    private List<Orders> orders;
    private String rate;
    private String start_dat;

    public String getRate() {
        return this.rate;
    }

    public String getStart_dat() {
        return this.start_dat;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public List<Orders> getOrders() {
        return this.orders;
    }
}
