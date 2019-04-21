package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class Status implements Serializable {
    private Company company;
    private Order order;
    private int status_id;

    public int getStatus_id() {
        return this.status_id;
    }

    public Order getOrder() {
        return this.order;
    }

    public Company getCompany() {
        return this.company;
    }
}
