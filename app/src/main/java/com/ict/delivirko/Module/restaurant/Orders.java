package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class Orders implements Serializable {
    private String date;
    private Driver driver;
    private int id;
    private String time;

    public int getId() {
        return this.id;
    }

    public String getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
    }

    public Driver getDriver() {
        return this.driver;
    }
}
