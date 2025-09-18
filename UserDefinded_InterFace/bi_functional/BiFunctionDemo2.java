package bi_functional;

import java.util.Scanner;
import java.util.function.BiFunction;

public class BiFunctionDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BiFunction<Integer, Integer, Integer> calculateBill = (price, quantity) -> price * quantity;

        System.out.print("Enter product name: ");
        String product = sc.nextLine();

        System.out.print("Enter price of " + product + ": ");
        int price = sc.nextInt();

        System.out.print("Enter quantity of " + product + ": ");
        int qty = sc.nextInt();

        int total = calculateBill.apply(price, qty);

        System.out.println("\n---- Shopping Bill ----");
        System.out.println("Product: " + product);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + qty);
        System.out.println("Total Cost: " + total);

        sc.close();
    }
}
