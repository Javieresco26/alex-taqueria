package com.pluralsight.services;

import com.pluralsight.models.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {

        try {

            String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            String fileName = "receipts/" + timestamp + ".txt";

            FileWriter writer = new FileWriter(fileName);

            writer.write(order.toString());

            writer.close();

            System.out.println("Receipt Saved!");

        } catch (IOException e) {

            System.out.println("Error saving receipt.");

        }
    }
}