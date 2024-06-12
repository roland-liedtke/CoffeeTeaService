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

        // Wybór rodzaju napoju
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Coffee Or Tea Shop!");
        System.out.println("Choose a drink type (Coffee/Tea):");
        DrinkType drinkType;
        switch (scanner.nextLine()) {
            case "Coffee":
                drinkType = DrinkType.COFFEE;
                break;
            case "Tea":
            default:
                drinkType = DrinkType.TEA;
        }
        System.out.println("Your choice: " + drinkType);


        // Wybór rozmiaru napoju
        System.out.println("Choose a size (S, M, L):");
        DrinkSize drinkSize;
        switch (scanner.nextLine()) {
            case "S":
                drinkSize = DrinkSize.S;
                break;
            case "L":
                drinkSize = DrinkSize.L;
                break;
            case "M":
            default:
                drinkSize = DrinkSize.M;
        }
        System.out.println("Your choice: " + drinkSize);


        // Ustalenie ceny wyjściowej
        double initialPrice = 0.00;


        // Utworzenie nowego obiektu
        Drink drink = new Drink(drinkType, drinkSize, initialPrice);


        if(drinkType.equals(DrinkType.COFFEE)) {
            CoffeeService coffeeService = new CoffeeService(drink);
            System.out.println("Available additions: milk, sugar.");
            System.out.println("Add additions (type 'none' to skip, separate by comma for multiple):");
            String CoffeeAdditionsInput = scanner.nextLine();

            if (!CoffeeAdditionsInput.equalsIgnoreCase("none")) {
                String[] splitAdditions = CoffeeAdditionsInput.split(",");
                List<String> additions = new ArrayList<>();

                for (String addition : splitAdditions) {
                    additions.add(addition.trim());
                }

                //coffeeService.chooseAdditions(additions);
            }

            coffeeService.calculatePrice();
            coffeeService.order();

            savingFileService.saveOrder(coffeeService.order(), drink.getPrice());

        } else {
            TeaService teaService = new TeaService(drink);
            System.out.println("Available additions: sugar, honey, lemon");
            System.out.println("Add additions (type 'none' to skip, separate by comma for multiple):");
            String TeaAdditionsInput = scanner.nextLine();

            if (!TeaAdditionsInput.equalsIgnoreCase("none")) {
                String[] splitAdditions = TeaAdditionsInput.split(",");
                List<String> additions = new ArrayList<>();

                for (String addition : splitAdditions) {
                    additions.add(addition.trim());
                }

                //teaService.chooseAdditions(additions);
            }

            teaService.calculatePrice();

            // Wybór kodów zniżkowych
            System.out.println("Enter discount code (e.g., TEA10):");
            DiscountCode discountCode;
            switch (scanner.nextLine()) {
                case "TEA10":
                    discountCode = DiscountCode.TEA10;
                    break;
                case "TEA20":
                    discountCode = DiscountCode.TEA20;
                    break;
                case "TEA30":
                    discountCode = DiscountCode.TEA30;
                    break;
                default:
                    discountCode = DiscountCode.EMPTY;
            }


            DiscountService discountService = new DiscountService();

            discountService.applyDiscount(drink, discountCode);

            teaService.order();

            savingFileService.saveOrder(teaService.order(), drink.getPrice());


            System.out.println("The final price for your " + drinkType + " is: $" + drink.getPrice());

        }
        scanner.close();
    }
}