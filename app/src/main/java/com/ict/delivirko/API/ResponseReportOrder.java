package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.ReportData;
import java.io.Serializable;

public class ResponseReportOrder implements Serializable {
    private String message;
    @SerializedName("data")
    private ReportData reportData;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public ReportData getReportData() {
        return this.reportData;
    }
}
