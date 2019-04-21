package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.adapter.restaurant.Contacts;
import java.io.Serializable;
import java.util.List;

public class ResponseContact implements Serializable {
    @SerializedName("data")
    private List<Contacts> contactsList;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public List<Contacts> getContactsList() {
        return this.contactsList;
    }
}
