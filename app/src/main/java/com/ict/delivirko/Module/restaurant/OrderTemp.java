package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class OrderTemp implements Serializable {
    private int id;
    private int status;

    public int getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
