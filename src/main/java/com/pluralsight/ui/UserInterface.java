package com.pluralsight.ui;

import java.util.Scanner;
import com.pluralsight.models.Taco;
import com.pluralsight.models.Order;
import com.pluralsight.models.Drink;
import com.pluralsight.models.ChipsAndSalsa;
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

        System.out.print("Enter size (single, 3 taco, burrito): ");
        String size = scanner.nextLine();

        System.out.print("Enter shell: ");
        String shell = scanner.nextLine();

        System.out.print("Enter meat: ");
        String meat = scanner.nextLine();

        System.out.print("Enter cheese: ");
        String cheese = scanner.nextLine();

        System.out.print("Extra meat? (yes/no): ");
        boolean extraMeat =
                scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Extra cheese? (yes/no): ");
        boolean extraCheese =
                scanner.nextLine().equalsIgnoreCase("yes");

        return new Taco(
                size,
                shell,
                meat,
                cheese,
                extraMeat,
                extraCheese
        );
    }
    public Drink createDrink() {

        System.out.print("Enter size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);

    }
    public ChipsAndSalsa createChips() {

        System.out.print("Enter salsa type: ");
        String salsa = scanner.nextLine();

        return new ChipsAndSalsa(salsa);

    }
    public void checkout(Order order) {

        System.out.println(order);

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