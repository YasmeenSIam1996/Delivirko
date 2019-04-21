package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class TrackingOrderDetails implements Serializable {
    private Company company;
    private Driver driver;
    private Order order;

    public Driver getDriver() {
        return this.driver;
    }

    public Company getCompany() {
        return this.company;
    }

    public Order getOrder() {
        return this.order;
    }
}
