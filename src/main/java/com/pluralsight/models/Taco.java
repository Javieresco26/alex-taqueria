package com.pluralsight.models;

public class Taco {

    private String size;
    private String shell;
    private String meat;
    private String cheese;
    private boolean extraMeat;
    private boolean extraCheese;
    public Taco(String size,
                String shell,
                String meat,
                String cheese,
                boolean extraMeat,
                boolean extraCheese) {

        this.size = size;
        this.shell = shell;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;

    }

    public double getPrice() {

        double price = 0;

        switch (size.toLowerCase()) {

            case "single":
                price += 3.50;
                price += 1.00;
                price += .75;
                if (extraMeat) {
                    price += .50;
                }

                if (extraCheese) {
                    price += .30;
                }
                break;

            case "3 taco":
                price += 9.00;
                price += 2.00;
                price += 1.50;
                if (extraMeat) {
                    price += .50;
                }

                if (extraCheese) {
                    price += .30;
                }
                break;

            case "burrito":
                price += 8.50;
                price += 3.00;
                price += 2.25;
                if (extraMeat) {
                    price += .50;
                }

                if (extraCheese) {
                    price += .30;
                }
                break;
        }

        return price;
    }

    @Override
    public String toString() {

        return "\n=== TACO DETAILS ===" +
                "\nSize: " + size +
                "\nShell: " + shell +
                "\nMeat: " + meat +
                "\nCheese: " + cheese +
                "\nExtra Meat: " + extraMeat +
                "\nExtra Cheese: " + extraCheese +
                "\nPrice: $" + getPrice();
    }
}