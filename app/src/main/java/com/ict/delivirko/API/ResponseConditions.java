package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.fragment.Conditions;

public class ResponseConditions {
    @SerializedName("data")
    private Conditions conditions;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public Conditions getConditions() {
        return this.conditions;
    }
}
