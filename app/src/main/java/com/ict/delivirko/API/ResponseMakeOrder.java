package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.MakeOrderData;
import java.io.Serializable;

public class ResponseMakeOrder implements Serializable {
    @SerializedName("data")
    private MakeOrderData makeOrderData;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public MakeOrderData getMakeOrderData() {
        return this.makeOrderData;
    }
}
