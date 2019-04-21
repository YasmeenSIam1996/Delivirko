package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.fragment.pilot.MyOrderData;

public class ResponseOrderPilot {
    private String message;
    @SerializedName("data")
    private MyOrderData myOrderData;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public MyOrderData getMyOrder() {
        return this.myOrderData;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResponseOrderPilot{status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", myOrderData=");
        stringBuilder.append(this.myOrderData);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
