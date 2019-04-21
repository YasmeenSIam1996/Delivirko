package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;
import java.util.List;

public class BillData implements Serializable {
    private String end_date;
    private List<BillOrders> orders;
    private String start_date;
    private double total_price;

    public List<BillOrders> getOrders() {
        return this.orders;
    }

    public double getTotal_price() {
        return this.total_price;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public String getStart_date() {
        return this.start_date;
    }
}
