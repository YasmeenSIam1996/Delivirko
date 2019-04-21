package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.BillData;
import java.io.Serializable;

public class ResponseBillResData implements Serializable {
    @SerializedName("data")
    private BillData billData;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public BillData getBillData() {
        return this.billData;
    }
}
