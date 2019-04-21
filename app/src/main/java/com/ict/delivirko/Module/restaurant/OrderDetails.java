package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class OrderDetails extends Orders implements Serializable {
    private int apartment_no;
    private int building_no;
    private double company_rating;
    private String driver_code;
    private int floor_no;
    private String order_type;
    private int payment;
    private String place;
    private float points;
    private double price;
    private double shipping;
    private String street;

    public String getPlace() {
        return this.place;
    }

    public String getStreet() {
        return this.street;
    }

    public int getBuilding_no() {
        return this.building_no;
    }

    public int getApartment_no() {
        return this.apartment_no;
    }

    public int getFloor_no() {
        return this.floor_no;
    }

    public double getPrice() {
        return this.price;
    }

    public double getShipping() {
        return this.shipping;
    }

    public int getPayment() {
        return this.payment;
    }

    public double getCompany_rating() {
        return this.company_rating;
    }

    public String getOrder_type() {
        return this.order_type;
    }

    public String getDriver_code() {
        return this.driver_code;
    }

    public float getPoints() {
        return this.points;
    }
}
