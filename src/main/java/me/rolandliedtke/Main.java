package me.rolandliedtke;

import me.rolandliedtke.model.DiscountCode;
import me.rolandliedtke.model.Drink;
import me.rolandliedtke.model.DrinkSize;
import me.rolandliedtke.model.DrinkType;
import me.rolandliedtke.service.CoffeeService;
import me.rolandliedtke.service.DiscountService;
import me.rolandliedtke.service.TeaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SavingFileService savingFileService = new SavingFileService();

//           // savingFileService.saveOrder(coffeeService.order(), drink.getPrice());
//
//            // Wybór kodów zniżkowych
//            System.out.println("Enter discount code (e.g., TEA10):");
//            DiscountCode discountCode;
//            switch (scanner.nextLine()) {
//                case "TEA10":
//                    discountCode = DiscountCode.TEA10;
//                    break;
//                case "TEA20":
//                    discountCode = DiscountCode.TEA20;
//                    break;
//                case "TEA30":
//                    discountCode = DiscountCode.TEA30;
//                    break;
//                default:
//                    discountCode = DiscountCode.EMPTY;
//            }
//
//
//             discountService = new DiscountService();
//
//            discountService.applyDiscount(drink, discountCode);
//
//
//            savingFileService.saveOrder(teaService.order(), drink.getPrice());
//
//
//            System.out.println("The final price for your " + drinkType + " is: $" + drink.getPrice());
//
//        }
//        scanner.close();
    }
}