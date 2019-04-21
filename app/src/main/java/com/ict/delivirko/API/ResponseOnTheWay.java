package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.pilot.OnTheWay;

public class ResponseOnTheWay {
    private String message;
    @SerializedName("data")
    private OnTheWay onTheWay;
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

    public OnTheWay getOnTheWay() {
        return this.onTheWay;
    }
}
