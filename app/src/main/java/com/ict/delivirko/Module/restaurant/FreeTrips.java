package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class FreeTrips implements Serializable {
    private int company_id;
    private double discount_max_value;
    private double discount_rate;
    private int end_at;
    private int id;
    private int order_num;
    private int order_num_used;

    public int getId() {
        return this.id;
    }

    public int getCompany_id() {
        return this.company_id;
    }

    public int getOrder_num() {
        return this.order_num;
    }

    public int getOrder_num_used() {
        return this.order_num_used;
    }

    public double getDiscount_rate() {
        return this.discount_rate;
    }

    public double getDiscount_max_value() {
        return this.discount_max_value;
    }

    public int getEnd_at() {
        return this.end_at;
    }
}
