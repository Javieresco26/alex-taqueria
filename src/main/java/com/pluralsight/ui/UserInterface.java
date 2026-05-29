package com.pluralsight.ui;

import java.util.Scanner;
import com.pluralsight.models.*;
import com.pluralsight.services.ReceiptWriter;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void display() {

        boolean running = true;

        while (running) {

            System.out.println("\n=== ALEX-TAQUERIA ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    processOrder();
                    break;

                case 0:
                    running = false;
                    System.out.println("ADIOS!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void processOrder() {
        Order order = new Order();

        boolean ordering = true;

        while (ordering) {

            System.out.println("\n=== ORDER SCREEN ===");
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    Taco taco = createTaco();
                    order.addTaco(taco);
                    System.out.println("Taco Added!");
                    break;

                case 2:
                    Drink drink = createDrink();

                    order.addDrink(drink);

                    System.out.println("Drink Added!");
                    break;

                case 3:
                    ChipsAndSalsa chips = createChips();

                    order.addChips(chips);

                    System.out.println("Chips Added!");
                    break;

                case 4:
                    checkout(order);
                    ordering = false;
                    break;

                case 0:
                    System.out.println("Order Cancelled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public Taco createTaco() {
        System.out.println("\nChoose Type:");
        System.out.println("1) Single");
        System.out.println("2) 3 Taco");
        System.out.println("3) Burrito");

        int typeChoice = Integer.parseInt(scanner.nextLine());

        String type = "";

        switch (typeChoice) {

            case 1:
                type= "Single";
                break;

            case 2:
                type = "3 Taco";
                break;

            case 3:
                type = "Burrito";
                break;
        }

        String shell = "";

        if (type.equalsIgnoreCase("Burrito")) {

            shell = "Flour Tortilla";

        } else {

            System.out.println("\nChoose Shell:");
            System.out.println("1) Corn");
            System.out.println("2) Flour");
            System.out.println("3) Hard Shell");
            System.out.println("4) Bowl");

            int shellChoice = Integer.parseInt(scanner.nextLine());

            switch (shellChoice) {

                case 1:
                    shell = "Corn";
                    break;

                case 2:
                    shell = "Flour";
                    break;

                case 3:
                    shell = "Hard Shell";
                    break;

                case 4:
                    shell = "Bowl";
                    break;
            }
        }
        Taco taco = new Taco(type, shell);

        boolean addingMeats = true;

        while (addingMeats) {

            System.out.println("\nAvailable Meats:");
            System.out.println("0) None / Done");
            System.out.println("1) Carne Asada");
            System.out.println("2) Al Pastor");
            System.out.println("3) Carnitas");
            System.out.println("4) Pollo");
            System.out.println("5) Chorizo");
            System.out.println("6) Pescado");

            int meatChoice = Integer.parseInt(scanner.nextLine());

            switch (meatChoice) {
                case 0:
                    addingMeats = false;
                    continue;
                case 1:
                    taco.addMeat("Carne Asada");
                    break;
                case 2:
                    taco.addMeat("Al Pastor");
                    break;
                case 3:
                    taco.addMeat("Carnitas");
                    break;
                case 4:
                    taco.addMeat("Pollo");
                    break;
                case 5:
                    taco.addMeat("Chorizo");
                    break;
                case 6:
                    taco.addMeat("Pescado");
                    break;
            }

            System.out.print("Add another meat? yes/no: ");
            addingMeats = scanner.nextLine().equalsIgnoreCase("yes");
        }

        boolean addingCheese = true;

        while (addingCheese) {

            System.out.println("\nAvailable Cheeses:");
            System.out.println("0) None / Done");
            System.out.println("1) Queso Fresco");
            System.out.println("2) Oaxaca");
            System.out.println("3) Cotija");
            System.out.println("4) Cheddar");

            int cheeseChoice = Integer.parseInt(scanner.nextLine());

            switch (cheeseChoice) {
                case 0:
                    addingCheese = false;
                    continue;
                case 1:
                    taco.addCheese("Queso Fresco");
                    break;
                case 2:
                    taco.addCheese("Oaxaca");
                    break;
                case 3:
                    taco.addCheese("Cotija");
                    break;
                case 4:
                    taco.addCheese("Cheddar");
                    break;
            }

            System.out.print("Add another cheese? yes/no: ");
            addingCheese = scanner.nextLine().equalsIgnoreCase("yes");
        }


        boolean addingToppings = true;

        while (addingToppings) {

            System.out.println("\nRegular Toppings:");
            System.out.println("0) None / Done");
            System.out.println("1) Lettuce");
            System.out.println("2) Cilantro");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapenos");
            System.out.println("6) Radishes");
            System.out.println("7) Pico De Gallo");
            System.out.println("8) Guacamole");
            System.out.println("9) Corn");
            System.out.println("10) Lime Wedges");
            System.out.println("11) Crema");

            int toppingChoice = Integer.parseInt(scanner.nextLine());

            switch (toppingChoice) {
                case 0:
                    addingToppings = false;
                    continue;
                case 1:
                    taco.addRegularTopping("Lettuce");
                    break;
                case 2:
                    taco.addRegularTopping("Cilantro");
                    break;
                case 3:
                    taco.addRegularTopping("Onions");
                    break;
                case 4:
                    taco.addRegularTopping("Tomatoes");
                    break;
                case 5:
                    taco.addRegularTopping("Jalapenos");
                    break;
                case 6:
                    taco.addRegularTopping("Radishes");
                    break;
                case 7:
                    taco.addRegularTopping("Pico De Gallo");
                    break;
                case 8:
                    taco.addRegularTopping("Guacamole");
                    break;
                case 9:
                    taco.addRegularTopping("Corn");
                    break;
                case 10:
                    taco.addRegularTopping("Lime Wedges");
                    break;
                case 11:
                    taco.addRegularTopping("Crema");
                    break;
            }

            System.out.print("Add another topping? yes/no: ");
            addingToppings = scanner.nextLine().equalsIgnoreCase("yes");
        }


        boolean addingSauces = true;

        while (addingSauces) {

            System.out.println("\nAvailable Sauces:");
            System.out.println("0) None / Done");
            System.out.println("1) Salsa Verde");
            System.out.println("2) Salsa Roja");
            System.out.println("3) Chipotle");
            System.out.println("4) Habanero");
            System.out.println("5) Mild");
            System.out.println("6) Extra Hot");

            int sauceChoice = Integer.parseInt(scanner.nextLine());

            switch (sauceChoice) {
                case 0:
                    addingSauces = false;
                    continue;
                case 1:
                    taco.addSauce("Salsa Verde");
                    break;
                case 2:
                    taco.addSauce("Salsa Roja");
                    break;
                case 3:
                    taco.addSauce("Chipotle");
                    break;
                case 4:
                    taco.addSauce("Habanero");
                    break;
                case 5:
                    taco.addSauce("Mild");
                    break;
                case 6:
                    taco.addSauce("Extra Hot");
                    break;
            }

            System.out.print("Add another sauce? yes/no: ");
            addingSauces = scanner.nextLine().equalsIgnoreCase("yes");
        }


        System.out.print("\nExtra meat? yes/no: ");

        boolean extraMeat =
                scanner.nextLine().equalsIgnoreCase("yes");

        taco.setExtraMeat(extraMeat);

        System.out.print("Extra cheese? yes/no: ");

        boolean extraCheese =
                scanner.nextLine().equalsIgnoreCase("yes");

        taco.setExtraCheese(extraCheese);


        System.out.print("Covered in salsa & queso? yes/no: ");

        boolean covered =
                scanner.nextLine().equalsIgnoreCase("yes");

        taco.setCovered(covered);

        return taco;
    }
    public Drink createDrink() {

        System.out.println("\nChoose Drink:");
        System.out.println("1) Horchata");
        System.out.println("2) Jamaica");
        System.out.println("3) Agua De Melon");
        System.out.println("4) Fountain Drink");

        int drinkChoice = Integer.parseInt(scanner.nextLine());

        String flavor = "";

        switch (drinkChoice) {

            case 1:
                flavor = "Horchata";
                break;

            case 2:
                flavor = "Jamaica";
                break;

            case 3:
                flavor = "Agua De Melon";
                break;

            case 4:
                flavor = "Fountain Drink";
                break;
        }

        System.out.println("\nChoose Size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int sizeChoice = Integer.parseInt(scanner.nextLine());

        String size = "";

        switch (sizeChoice) {

            case 1:
                size = "Small";
                break;

            case 2:
                size = "Medium";
                break;

            case 3:
                size = "Large";
                break;
        }

        return new Drink(size, flavor);
    }
    public ChipsAndSalsa createChips() {

        System.out.println("\nChoose Salsa:");
        System.out.println("1) Salsa Verde");
        System.out.println("2) Salsa Roja");
        System.out.println("3) Chipotle");
        System.out.println("4) Habanero");

        int salsaChoice = Integer.parseInt(scanner.nextLine());

        String salsa = "";

        switch (salsaChoice) {

            case 1:
                salsa = "Salsa Verde";
                break;

            case 2:
                salsa = "Salsa Roja";
                break;

            case 3:
                salsa = "Chipotle";
                break;

            case 4:
                salsa = "Habanero";
                break;
        }

        return new ChipsAndSalsa(salsa);
    }

    public void checkout(Order order) {

        System.out.println(order);

        if (order.getTacoCount() == 0
                && order.getDrinkCount() == 0
                && order.getChipCount() == 0) {

            System.out.println("You must order drinks or chips if no tacos.");

            return;
        }

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {

            ReceiptWriter.saveReceipt(order);

            System.out.println("Order Completed!");

        } else {

            System.out.println("Order Cancelled.");
        }
    }
}