package com.ict.delivirko.Module;

import java.io.Serializable;

public class UserDriver implements Serializable {
    private int active;
    private String car_number;
    private String email;
    private int id;
    private String image;
    private boolean isDriver;
    private String name;
    private String phone;
    private String token;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getActive() {
        return this.active;
    }

    public String getCar_number() {
        return this.car_number;
    }

    public String getToken() {
        return this.token;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setActive(int i) {
        this.active = i;
    }

    public void setCar_number(String str) {
        this.car_number = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public boolean isDriver() {
        return this.isDriver;
    }

    public void setDriver(boolean z) {
        this.isDriver = z;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
