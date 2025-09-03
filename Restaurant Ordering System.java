/*
 * Author: Michael Weber
 * Class: 202610:10037 Object-Oriented Programming (ITSE-2321-201)
 * Date: 09/03/2025
 * Assignment: Restaurant Ordering System Using Methods
 * Description: This program allows users to order food items from a menu,
 * calculates the total cost, and applies a discount if provided.
 */

import java.util.Scanner;

public class RestaurantOrder {

    // Displays the menu to the user
    public static void showMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Burger - $5.99");
        System.out.println("2. Pizza  - $8.99");
        System.out.println("3. Salad  - $4.99");
        System.out.println("4. Soda   - $1.99");
        System.out.println("------------------");
    }

    // Returns the price of the item based on the item number
    public static double getPriceForItem(int itemNum) {
        switch (itemNum) {
            case 1: return 5.99; // Burger
            case 2: return 8.99; // Pizza
            case 3: return 4.99; // Salad
            case 4: return 1.99; // Soda
            default: return 0.0; // Invalid item
        }
    }

    // This method handles the ordering process
    public static void startOrder() {
        Scanner input = new Scanner(System.in);
        double total = 0.0;

        System.out.println("Enter the item number to order (0 to finish):");

        while (true) {
            int itemNumber = input.nextInt();

            if (itemNumber == 0) {
                break;
            }

            double itemPrice = getPriceForItem(itemNumber);

            if (itemPrice == 0.0) {
                System.out.println("Invalid selection. Please choose from the menu.");
            } else {
                total += itemPrice;
                System.out.printf("Added $%.2f to total. Current total: $%.2f%n", itemPrice, total);
            }
        }

        // Ask if user has a discount
        input.nextLine(); // clear buffer
        System.out.print("Do you have a discount code? (yes/no): ");
        String hasDiscount = input.nextLine();

        if (hasDiscount.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage (e.g., 10 for 10%): ");
            double discountPercent = input.nextDouble();
            total = getFinalTotal(total, discountPercent);
        } else {
            total = getFinalTotal(total);
        }

        System.out.printf("Your final total is: $%.2f%n", total);
    }

    // Calculates total without discount
    public static double getFinalTotal(double totalAmount) {
        return totalAmount;
    }

    // Overloaded method to apply a discount
    public static double getFinalTotal(double totalAmount, double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            System.out.println("Invalid discount. No discount applied.");
            return totalAmount;
        }

        double discountAmount = totalAmount * (discountPercent / 100.0);
        return totalAmount - discountAmount;
    }

    // Main method to start the program
    public static void main(String[] args) {
        showMenu();
        startOrder();
    }
}