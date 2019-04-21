package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.pilot.DataNearestCompany;
import java.io.Serializable;

public class ResponseNearestDriver implements Serializable {
    @SerializedName("data")
    private DataNearestCompany dataNearestCompany;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public DataNearestCompany getDataNearestCompany() {
        return this.dataNearestCompany;
    }
}
