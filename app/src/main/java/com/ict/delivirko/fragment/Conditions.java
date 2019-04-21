package com.ict.delivirko.fragment;

import java.io.Serializable;

public class Conditions implements Serializable {
    private String title;
    private String value;

    public String getTitle() {
        return this.title;
    }

    public String getValue() {
        return this.value;
    }
}
