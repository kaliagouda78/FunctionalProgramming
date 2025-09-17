package bi_predicate;

import java.util.Scanner;
import java.util.function.BiPredicate;

record Product(String productName, double productPrice, double productRating) {
    public Product {
        if (productName == null || productName.isEmpty() || productPrice < 0 || productRating < 0) {
            throw new IllegalArgumentException("❌ Invalid Product Details Provided!");
        }
    }
}

public class FilterProduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Product Rating (0 - 5): ");
        double rating = sc.nextDouble();

        Product userProduct = new Product(name, price, rating);

        BiPredicate<Double, Double> filter = (p, r) -> p >= 5000 && r >= 4;

        System.out.println(userProduct.productName() + " → Good Deal? " 
                           + filter.test(userProduct.productPrice(), userProduct.productRating()));

        sc.close();
    }
}
