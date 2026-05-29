package com.pluralsight.models;

import java.util.ArrayList;

public class Taco {
    private String type;
    private String shell;

    private ArrayList<String> meats = new ArrayList<>();
    private ArrayList<String> cheeses = new ArrayList<>();
    private ArrayList<String> regularToppings = new ArrayList<>();
    private ArrayList<String> sauces = new ArrayList<>();

    private boolean extraMeat;
    private boolean extraCheese;
    private boolean covered;

    public void addMeat(String meat) {

        meats.add(meat);

    }

    public void addCheese(String cheese) {

        cheeses.add(cheese);

    }

    public void addRegularTopping(String topping) {

        regularToppings.add(topping);

    }

    public void addSauce(String sauce) {

        sauces.add(sauce);

    }


    public void setExtraMeat(boolean extraMeat) {

        this.extraMeat = extraMeat;

    }

    public void setExtraCheese(boolean extraCheese) {

        this.extraCheese = extraCheese;

    }

    public void setCovered(boolean covered) {

        this.covered = covered;

    }

    public Taco(String type, String shell) {

        this.type = type;
        this.shell = shell;
    }

    public double getPrice() {

        double price = 0;

        switch (type.toLowerCase()) {

            case "single":

                price += 3.50;
                price += meats.size() * 1.00;
                price += cheeses.size() * .75;

                if (extraMeat) {
                    price += .50;
                }

                if (extraCheese) {
                    price += .30;
                }

                break;

            case "3 taco":

                price += 9.00;
                price += meats.size() * 2.00;
                price += cheeses.size() * 1.50;

                if (extraMeat) {
                    price += 1.00;
                }

                if (extraCheese) {
                    price += .60;
                }

                break;

            case "burrito":

                price += 8.50;
                price += meats.size() * 3.00;
                price += cheeses.size() * 2.25;

                if (extraMeat) {
                    price += 1.50;
                }

                if (extraCheese) {
                    price += .90;
                }

                break;
        }

        return price;
    }

    @Override
    public String toString() {

        return "\n=== TACO DETAILS ===" +
                "\nType: " + type +
                "\nShell: " + shell +
                "\nMeats: " + (meats.isEmpty() ? "No" : meats) +
                "\nCheeses: " + (cheeses.isEmpty() ? "No" : cheeses) +
                "\nRegular Toppings: " + (regularToppings.isEmpty() ? "No" : regularToppings) +
                "\nSauces: " + (sauces.isEmpty() ? "No" : sauces) +
                "\nExtra Meat: " + (extraMeat ? "Yes" : "No") +
                "\nExtra Cheese: " + (extraCheese ? "Yes" : "No") +
                "\nCovered: " + (covered ? "Yes" : "No") +
                "\nPrice: $" + String.format("%.2f", getPrice());
    }
}