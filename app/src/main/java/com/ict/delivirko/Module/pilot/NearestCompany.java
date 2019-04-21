package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class NearestCompany implements Serializable {
    private int company_id;
    private String distance;
    private String image;
    private double lat;
    private double lng;
    private String name;
    private String time;

    public int getDriver_id() {
        return this.company_id;
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

    public int getCompany_id() {
        return this.company_id;
    }

    public String getImage() {
        return this.image;
    }
}
