package com.ict.delivirko.Module.restaurant;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MakeOrderData implements Serializable {
    private free_trips free_trips;
    @SerializedName("places")
    private List<places> placesList;

    public List<places> getPlacesList() {
        return this.placesList;
    }

    public free_trips getFree_trips() {
        return this.free_trips;
    }
}
