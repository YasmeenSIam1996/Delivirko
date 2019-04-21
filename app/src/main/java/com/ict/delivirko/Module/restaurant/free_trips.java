package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class free_trips implements Serializable {
    private String end_at;
    private int id;
    private int remain_trips;

    public int getId() {
        return this.id;
    }

    public int getRemain_trips() {
        return this.remain_trips;
    }

    public String getEnd_at() {
        return this.end_at;
    }
}
