package com.ict.delivirko.Module.restaurant;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataNearestDriver implements Serializable {
    private String address;
    private int id;
    private double lat;
    private double lng;
    @SerializedName("nearest_driver")
    private NearestDriver nearestDriver;

    public int getId() {
        return this.id;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public NearestDriver getNearestDriver() {
        return this.nearestDriver;
    }
}
