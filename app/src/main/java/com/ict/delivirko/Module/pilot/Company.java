package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class Company implements Serializable {
    private String address;
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

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", image='");
        stringBuilder.append(this.image);
        stringBuilder.append('\'');
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", lng=");
        stringBuilder.append(this.lng);
        stringBuilder.append(", address='");
        stringBuilder.append(this.address);
        stringBuilder.append('\'');
        stringBuilder.append(", phone='");
        stringBuilder.append(this.phone);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
