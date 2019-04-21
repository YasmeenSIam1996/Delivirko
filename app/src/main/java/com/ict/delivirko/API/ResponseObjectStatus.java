package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.pilot.Status;

public class ResponseObjectStatus {
    private String message;
    private boolean status;
    @SerializedName("data")
    private Status status_;

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

    public Status getStatus_() {
        return this.status_;
    }
}
