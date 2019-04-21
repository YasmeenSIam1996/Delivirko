package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.UserDriver;

public class ResponseSign {
    private String message;
    private boolean status;
    @SerializedName("data")
    private UserDriver user;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public UserDriver getUser() {
        return this.user;
    }
}
