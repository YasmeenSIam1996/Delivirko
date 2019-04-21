package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.FreeTrips;
import java.io.Serializable;

public class ResponseFreeTrips implements Serializable {
    @SerializedName("data")
    private FreeTrips freeTrips;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public FreeTrips getFreeTrips() {
        return this.freeTrips;
    }
}
