package com.ict.delivirko.Module.pilot;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MyOrder implements Serializable {
    private String date;
    private int id;
    private int is_paid;
    @SerializedName("orders")
    private List<MyOrderDetails> myOrderDetails;
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

    public List<MyOrderDetails> getMyOrderDetails() {
        return this.myOrderDetails;
    }

    public void setMyOrderDetails(List<MyOrderDetails> list) {
        this.myOrderDetails = list;
    }

    public int getIs_paid() {
        return this.is_paid;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyOrder{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", time='");
        stringBuilder.append(this.time);
        stringBuilder.append('\'');
        stringBuilder.append(", date='");
        stringBuilder.append(this.date);
        stringBuilder.append('\'');
        stringBuilder.append(", is_paid=");
        stringBuilder.append(this.is_paid);
        stringBuilder.append(", myOrderDetails=");
        stringBuilder.append(this.myOrderDetails);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
