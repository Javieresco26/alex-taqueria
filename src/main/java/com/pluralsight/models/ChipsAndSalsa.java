package com.pluralsight.models;

public class ChipsAndSalsa {

    private String salsaType;

    public ChipsAndSalsa(String salsaType) {

        this.salsaType = salsaType;

    }

    public double getPrice() {

        return 1.50;

    }

    @Override
    public String toString() {

        return "Chips & Salsa (" + salsaType + ") - $1.50";

    }
}