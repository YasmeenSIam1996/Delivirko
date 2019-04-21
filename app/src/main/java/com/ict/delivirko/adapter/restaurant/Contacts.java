package com.ict.delivirko.adapter.restaurant;

import java.io.Serializable;

public class Contacts implements Serializable {
    private String name;
    private String title;
    private String value;

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getValue() {
        return this.value;
    }
}
