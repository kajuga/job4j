package ru.job4j.bank;

public class Account {
    private String details;
    private double cash;



    public Account(String details, double cash) {
        this.details = details;
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
