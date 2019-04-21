package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.MyOrderDetails;
import java.io.Serializable;

public class ResponseMyOrderDetails implements Serializable {
    private String message;
    @SerializedName("data")
    private MyOrderDetails myOrderDetails;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public MyOrderDetails getMyOrderDetails() {
        return this.myOrderDetails;
    }
}
