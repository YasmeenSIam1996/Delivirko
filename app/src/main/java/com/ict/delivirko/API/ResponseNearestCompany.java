package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.DataNearestDriver;
import java.io.Serializable;

public class ResponseNearestCompany implements Serializable {
    @SerializedName("data")
    private DataNearestDriver dataNearestDriver;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public DataNearestDriver getDataNearestDriver() {
        return this.dataNearestDriver;
    }
}
