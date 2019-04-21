package com.ict.delivirko.Module.restaurant;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TrackingOrderData implements Serializable {
    @SerializedName("order")
    private Company company;
    private Driver driver;

    public Driver getDriver() {
        return this.driver;
    }

    public Company getCompany() {
        return this.company;
    }
}
