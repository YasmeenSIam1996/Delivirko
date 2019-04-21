package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class DriverTracking implements Serializable {
    private Driver driver;
    private int id;
    private int status_id;

    public int getId() {
        return this.id;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public int getStatus_id() {
        return this.status_id;
    }
}
