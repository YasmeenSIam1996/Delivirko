package com.ict.delivirko.Module;

import java.io.Serializable;

public class OrderNotification implements Serializable {
    private String company_address;
    private String company_lat;
    private String company_lng;
    private String company_name;
    private String distance;
    private String driver_car_number;
    private String driver_id;
    private String driver_image;
    private String driver_lat;
    private String driver_lng;
    private String driver_name;
    private String driver_phone;
    private String driver_rating;
    private int driver_rating_count;
    private String duration;
    private String order_id;
    private String order_status;
    private String order_status_text;
    private String status_id;
    private String waiting_time;

    public String getStatus_id() {
        return this.status_id;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getDriver_id() {
        return this.driver_id;
    }

    public String getDriver_car_number() {
        return this.driver_car_number;
    }

    public String getDriver_phone() {
        return this.driver_phone;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getDriver_lat() {
        return this.driver_lat;
    }

    public String getDriver_lng() {
        return this.driver_lng;
    }

    public String getOrder_status() {
        return this.order_status;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public String getDriver_name() {
        return this.driver_name;
    }

    public String getDriver_rating() {
        return this.driver_rating;
    }

    public String getOrder_status_text() {
        return this.order_status_text;
    }

    public String getDriver_image() {
        return this.driver_image;
    }

    public int getDriver_rating_count() {
        return this.driver_rating_count;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OrderNotification{status_id='");
        stringBuilder.append(this.status_id);
        stringBuilder.append('\'');
        stringBuilder.append(", duration='");
        stringBuilder.append(this.duration);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_id='");
        stringBuilder.append(this.driver_id);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_car_number='");
        stringBuilder.append(this.driver_car_number);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_phone='");
        stringBuilder.append(this.driver_phone);
        stringBuilder.append('\'');
        stringBuilder.append(", distance='");
        stringBuilder.append(this.distance);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_lat='");
        stringBuilder.append(this.driver_lat);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_lng='");
        stringBuilder.append(this.driver_lng);
        stringBuilder.append('\'');
        stringBuilder.append(", order_status='");
        stringBuilder.append(this.order_status);
        stringBuilder.append('\'');
        stringBuilder.append(", order_id='");
        stringBuilder.append(this.order_id);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_name='");
        stringBuilder.append(this.driver_name);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_rating='");
        stringBuilder.append(this.driver_rating);
        stringBuilder.append('\'');
        stringBuilder.append(", order_status_text='");
        stringBuilder.append(this.order_status_text);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_image='");
        stringBuilder.append(this.driver_image);
        stringBuilder.append('\'');
        stringBuilder.append(", driver_rating_count=");
        stringBuilder.append(this.driver_rating_count);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void setStatus_id(String str) {
        this.status_id = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setDriver_id(String str) {
        this.driver_id = str;
    }

    public void setDriver_car_number(String str) {
        this.driver_car_number = str;
    }

    public void setDriver_phone(String str) {
        this.driver_phone = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setDriver_lat(String str) {
        this.driver_lat = str;
    }

    public void setDriver_lng(String str) {
        this.driver_lng = str;
    }

    public void setOrder_status(String str) {
        this.order_status = str;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setDriver_name(String str) {
        this.driver_name = str;
    }

    public void setDriver_rating(String str) {
        this.driver_rating = str;
    }

    public void setOrder_status_text(String str) {
        this.order_status_text = str;
    }

    public void setDriver_image(String str) {
        this.driver_image = str;
    }

    public void setDriver_rating_count(int i) {
        this.driver_rating_count = i;
    }

    public String getWaiting_time() {
        return this.waiting_time;
    }

    public void setWaiting_time(String str) {
        this.waiting_time = str;
    }

    public String getCompany_name() {
        return this.company_name;
    }

    public void setCompany_name(String str) {
        this.company_name = str;
    }

    public String getCompany_address() {
        return this.company_address;
    }

    public void setCompany_address(String str) {
        this.company_address = str;
    }

    public String getCompany_lng() {
        return this.company_lng;
    }

    public void setCompany_lng(String str) {
        this.company_lng = str;
    }

    public String getCompany_lat() {
        return this.company_lat;
    }

    public void setCompany_lat(String str) {
        this.company_lat = str;
    }
}
