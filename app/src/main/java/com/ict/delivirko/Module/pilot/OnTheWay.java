package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class OnTheWay implements Serializable {
    private Company company;
    private Order order;

    public Order getOrder() {
        return this.order;
    }

    public Company getCompany() {
        return this.company;
    }
}
