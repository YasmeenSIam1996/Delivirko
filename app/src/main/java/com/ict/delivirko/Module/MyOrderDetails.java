package com.ict.delivirko.Module;

import java.io.Serializable;

public class MyOrderDetails implements Serializable {
    private int apartment_no;
    private int building_no;
    private float company_rating;
    private String date;
    private int floor_no;
    private int id;
    private String name;
    private String order_type;
    private int payment;
    private String place;
    private float points;
    private double price;
    private double shipping;
    private String street;
    private String time;

    public int getId() {
        return this.id;
    }

    public String getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
    }

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

    public float getPoints() {
        return this.points;
    }

    public String getOrder_type() {
        return this.order_type;
    }

    public float getCompany_rating() {
        return this.company_rating;
    }

    public String getName() {
        return this.name;
    }
}
