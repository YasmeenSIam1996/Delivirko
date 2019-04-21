package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.pilot.Pilot_bill;

public class ResponsePilotBill {
    private String message;
    @SerializedName("data")
    private Pilot_bill pilot_bill;
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

    public Pilot_bill getPilot_bill() {
        return this.pilot_bill;
    }
}
