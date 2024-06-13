package me.rolandliedtke;


import me.rolandliedtke.model.DiscountCode;
import me.rolandliedtke.service.DiscountService;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter discount code (e.g., TEA10):");
        DiscountCode discountCode;
        switch (scanner.nextLine()) {
            case "TEA10" -> discountCode = DiscountCode.TEA10;
            case "TEA20" -> discountCode = DiscountCode.TEA20;
            case "TEA30" -> discountCode = DiscountCode.TEA30;
            default -> discountCode = DiscountCode.EMPTY;
        };
        System.out.println("Your Code: " + discountCode);
        DiscountService discountService = new DiscountService();
        discountService.applyDiscount(String.valueOf(discountCode));

    }
}
