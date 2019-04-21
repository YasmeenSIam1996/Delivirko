package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class Company implements Serializable {
    private String address;
    private int id;
    private double lat;
    private double lng;

    public static class Orders implements Serializable {
        private String date;
        private double price;

        public String getDate() {
            return this.date;
        }

        public double getPrice() {
            return this.price;
        }
    }

    public int getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getAddress() {
        return this.address;
    }
}
