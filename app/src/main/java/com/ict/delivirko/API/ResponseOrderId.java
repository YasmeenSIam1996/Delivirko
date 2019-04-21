package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.OrderId;

public class ResponseOrderId {
    private String message;
    @SerializedName("data")
    private OrderId orderId;
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

    public OrderId getOrderId() {
        return this.orderId;
    }
}
