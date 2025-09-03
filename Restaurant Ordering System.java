import java.util.Scanner;

public class RestaurantOrder {

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Burger - $5.99");
        System.out.println("2. Pizza - $8.99");
        System.out.println("3. Salad - $4.99");
        System.out.println("4. Soda - $1.99");
    }

    public static double getItemPrice(int itemNumber) {
        switch (itemNumber) {
            case 1: return 5.99;
            case 2: return 8.99;
            case 3: return 4.99;
            case 4: return 1.99;
            default: return 0.0;
        }
    }

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;

        System.out.println("Enter the item number to order (0 to finish):");

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) break;

            double price = getItemPrice(choice);
            if (price == 0.0) {
                System.out.println("Invalid selection.");
            } else {
                totalCost += price;
                System.out.printf("Added $%.2f | Current total: $%.2f%n", price, totalCost);
            }
        }

        scanner.nextLine(); // clear buffer
        System.out.println("Do you have a discount? (yes/no)");
        String hasDiscount = scanner.nextLine();

        if (hasDiscount.equalsIgnoreCase("yes")) {
            System.out.println("Enter discount percentage:");
            double discount = scanner.nextDouble();
            totalCost = calculateTotal(totalCost, discount);
        } else {
            totalCost = calculateTotal(totalCost);
        }

        System.out.printf("Final total: $%.2f%n", totalCost);
    }

    public static double calculateTotal(double totalCost) {
        return totalCost;
    }

    public static double calculateTotal(double totalCost, double discount) {
        if (discount < 0 || discount > 100) {
            System.out.println("Invalid discount value. No discount applied.");
            return totalCost;
        }
        return totalCost - (totalCost * discount / 100.0);
    }

    public static void main(String[] args) {
        displayMenu();
        takeOrder();
    }
}