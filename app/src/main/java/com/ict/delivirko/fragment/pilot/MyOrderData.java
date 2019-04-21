package com.ict.delivirko.fragment.pilot;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.pilot.MyOrder;
import java.io.Serializable;
import java.util.List;

public class MyOrderData implements Serializable {
    private String end_date;
    @SerializedName("parent_orders")
    private List<MyOrder> myOrder;
    private String rate;
    private String start_date;

    public String getStart_date() {
        return this.start_date;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public String getRate() {
        return this.rate;
    }

    public List<MyOrder> getMyOrder() {
        return this.myOrder;
    }

    public void setMyOrder(List<MyOrder> list) {
        this.myOrder = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyOrderData{start_date='");
        stringBuilder.append(this.start_date);
        stringBuilder.append('\'');
        stringBuilder.append(", end_date='");
        stringBuilder.append(this.end_date);
        stringBuilder.append('\'');
        stringBuilder.append(", rate='");
        stringBuilder.append(this.rate);
        stringBuilder.append('\'');
        stringBuilder.append(", myOrder=");
        stringBuilder.append(this.myOrder);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
