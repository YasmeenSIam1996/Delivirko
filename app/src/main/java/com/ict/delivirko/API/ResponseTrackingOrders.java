package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.DriverTracking;
import java.util.List;

public class ResponseTrackingOrders {
    @SerializedName("data")
    private List<DriverTracking> driverTracking;
    private String message;
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

    public List<DriverTracking> getDriverTracking() {
        return this.driverTracking;
    }
}
