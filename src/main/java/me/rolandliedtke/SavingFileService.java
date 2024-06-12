package me.rolandliedtke;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavingFileService {
    public void saveOrder(String details, double price) {
        try (FileWriter fw = new FileWriter("Orders.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(details + " | Final Price: $" + price);
        } catch (IOException e) {
            System.err.println("There was a problem writing to the Orders.txt file: " + e.getMessage());
        }
    }
}
