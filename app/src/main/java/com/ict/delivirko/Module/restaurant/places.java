package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class places implements Serializable {
    private String address;
    private int id;
    private double lat;
    private double lng;
    private String name;
    private double price_from;
    private double price_to;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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

    public double getPrice_from() {
        return this.price_from;
    }

    public double getPrice_to() {
        return this.price_to;
    }
}
