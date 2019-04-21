package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.TrackingOrderData;

public class ResponseTrackingOrderData {
    private String message;
    private boolean status;
    @SerializedName("data")
    private TrackingOrderData trackingOrderData;

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

    public TrackingOrderData getTrackingOrderData() {
        return this.trackingOrderData;
    }
}
