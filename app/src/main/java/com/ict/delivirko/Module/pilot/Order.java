package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class Order implements Serializable {
    private String address;
    private int id;
    private double lat;
    private double lng;
    private String name;
    private String phone;
    private String place;
    private double price;
    private String waiting_time;

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPlace() {
        return this.place;
    }

    public String getWaiting_time() {
        return this.waiting_time;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", price=");
        stringBuilder.append(this.price);
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", lng=");
        stringBuilder.append(this.lng);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", address='");
        stringBuilder.append(this.address);
        stringBuilder.append('\'');
        stringBuilder.append(", phone='");
        stringBuilder.append(this.phone);
        stringBuilder.append('\'');
        stringBuilder.append(", place='");
        stringBuilder.append(this.place);
        stringBuilder.append('\'');
        stringBuilder.append(", waiting_time='");
        stringBuilder.append(this.waiting_time);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
