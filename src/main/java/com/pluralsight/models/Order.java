package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    private ArrayList<Taco> tacos = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<ChipsAndSalsa> chips = new ArrayList<>();

    public void addTaco(Taco taco) {

        tacos.add(taco);

    }
    public void addDrink(Drink drink) {

        drinks.add(drink);

    }
    public void addChips(ChipsAndSalsa chip) {

        chips.add(chip);

    }
    public double getTotal() {

        double total = 0;

        for (Taco taco : tacos) {

            total += taco.getPrice();

        }
        for (Drink drink : drinks) {

            total += drink.getPrice();

        }
        for (ChipsAndSalsa chip : chips) {

            total += chip.getPrice();

        }
        return total;
    }
    public int getTacoCount() {

        return tacos.size();

    }

    public int getDrinkCount() {

        return drinks.size();

    }

    public int getChipCount() {

        return chips.size();

    }
    @Override
    public String toString() {

        String output = "\n===== ORDER =====\n";

        for (Taco taco : tacos) {

            output += taco + "\n";

        }
        for (Drink drink : drinks) {

            output += drink + "\n";

        }
        for (ChipsAndSalsa chip : chips) {

            output += chip + "\n";

        }
        output += "\nTOTAL: $" + String.format("%.2f", getTotal());

        return output;
    }

}