package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class MyOrderDetails implements Serializable {
    private String date;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyOrderDetails{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", time='");
        stringBuilder.append(this.time);
        stringBuilder.append('\'');
        stringBuilder.append(", date='");
        stringBuilder.append(this.date);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
