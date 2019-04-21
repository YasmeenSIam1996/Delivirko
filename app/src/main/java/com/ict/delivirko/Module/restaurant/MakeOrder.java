package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class MakeOrder implements Serializable {
    private String apartment_no;
    private String building_no;
    private String floor_no;
    private String free_trip;
    private String name;
    private String order_id;
    private String payment;
    private String phone;
    private String place;
    private String place_id;
    private String price;
    private String shipping;
    private String special_mark;
    private String street;
    private String to_lat;
    private String to_lng;

    public MakeOrder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.order_id = str;
        this.name = str2;
        this.phone = str3;
        this.place = str4;
        this.street = str5;
        this.building_no = str6;
        this.apartment_no = str7;
        this.floor_no = str8;
        this.special_mark = str9;
        this.to_lat = str10;
        this.to_lng = str11;
        this.price = str12;
        this.shipping = str13;
        this.payment = str14;
        this.free_trip = str15;
        this.place_id = str16;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPlace() {
        return this.place;
    }

    public String getStreet() {
        return this.street;
    }

    public String getBuilding_no() {
        return this.building_no;
    }

    public String getApartment_no() {
        return this.apartment_no;
    }

    public String getFloor_no() {
        return this.floor_no;
    }

    public String getSpecial_mark() {
        return this.special_mark;
    }

    public String getTo_lat() {
        return this.to_lat;
    }

    public String getTo_lng() {
        return this.to_lng;
    }

    public String getPrice() {
        return this.price;
    }

    public String getShipping() {
        return this.shipping;
    }

    public String getPayment() {
        return this.payment;
    }

    public String getFree_trip() {
        return this.free_trip;
    }

    public String getPlace_id() {
        return this.place_id;
    }
}
