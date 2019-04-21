package com.ict.delivirko.Module.pilot;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class DataNearestCompany implements Serializable {
    private String address;
    private int id;
    private double lat;
    private double lng;
    @SerializedName("nearest_company")
    private List<NearestCompany> nearestCompanies;

    public int getId() {
        return this.id;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public List<NearestCompany> getNearestCompanies() {
        return this.nearestCompanies;
    }
}
