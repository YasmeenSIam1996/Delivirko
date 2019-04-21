package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class NearestDriver implements Serializable {
    private String distance;
    private int driver_id;
    private double lat;
    private double lng;
    private String name;
    private String time;

    public int getDriver_id() {
        return this.driver_id;
    }

    public String getName() {
        return this.name;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getTime() {
        return this.time;
    }
}
