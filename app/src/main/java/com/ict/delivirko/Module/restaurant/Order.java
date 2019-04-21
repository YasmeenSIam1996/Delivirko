package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class Order implements Serializable {
    private String address;
    private int company_rate;
    private double d_lat;
    private double d_lng;
    private int driver_rate;
    private int id;
    private float rate_count;
    private int status;
    private String status_text;

    public int getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatus_text() {
        return this.status_text;
    }

    public int getCompany_rate() {
        return this.company_rate;
    }

    public int getDriver_rate() {
        return this.driver_rate;
    }

    public double getD_lat() {
        return this.d_lat;
    }

    public double getD_lng() {
        return this.d_lng;
    }

    public float getRate_count() {
        return this.rate_count;
    }

    public String getAddress() {
        return this.address;
    }
}
