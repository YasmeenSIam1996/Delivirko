package com.ict.delivirko.Module.pilot;

import java.io.Serializable;

public class Pilot_bill implements Serializable {
    private float acceptanceRate;
    private double amount_cash;
    private int bag;
    private float completedRate;
    private int countOrders;
    private double countPoints;
    private int countTargets;
    private int countTargetsMoney;
    private int electronicPaymentService;
    private String from;
    private int guarantee;
    private int officePayment;
    private int rating;
    private int rejectOrder;
    private double revenue;
    private String to;
    private double wallet;
    private int workHours;

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getWorkHours() {
        return this.workHours;
    }

    public int getRating() {
        return this.rating;
    }

    public int getCountOrders() {
        return this.countOrders;
    }

    public double getCountPoints() {
        return this.countPoints;
    }

    public float getAcceptanceRate() {
        return this.acceptanceRate;
    }

    public float getCompletedRate() {
        return this.completedRate;
    }

    public int getRejectOrder() {
        return this.rejectOrder;
    }

    public int getCountTargets() {
        return this.countTargets;
    }

    public int getCountTargetsMoney() {
        return this.countTargetsMoney;
    }

    public int getOfficePayment() {
        return this.officePayment;
    }

    public int getElectronicPaymentService() {
        return this.electronicPaymentService;
    }

    public int getBag() {
        return this.bag;
    }

    public int getGuarantee() {
        return this.guarantee;
    }

    public double getWallet() {
        return this.wallet;
    }

    public double getRevenue() {
        return this.revenue;
    }

    public double getAmount_cash() {
        return this.amount_cash;
    }
}
