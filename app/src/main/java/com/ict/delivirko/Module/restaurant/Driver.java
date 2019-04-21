package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class Driver implements Serializable {
    private String car_number;
    private float driver_rating;
    private int driver_rating_count;
    private int id;
    private String image;
    private double lat;
    private double lng;
    private String name;
    private String phone;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getCar_number() {
        return this.car_number;
    }

    public String getPhone() {
        return this.phone;
    }

    public float getDriver_rating() {
        return this.driver_rating;
    }

    public int getDriver_rating_count() {
        return this.driver_rating_count;
    }
}
