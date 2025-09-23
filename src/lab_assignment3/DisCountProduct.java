package lab_assignment3;

import java.util.Scanner;
import java.util.function.Function;

record Product(Integer id,String name,Double price) {
	
}
public class DisCountProduct {
public static void main(String[] args) {
Scanner sc=new Scanner (System.in);
System.out.println("Enter Product Id  ");
int id=Integer.parseInt(sc.nextLine());
System.out.println("Enter Product Name  :");
String name=sc.nextLine();
System.out.println("Enter Product price");
double price=Double.parseDouble(sc.nextLine());
Function<Product, Double> productDis=product->{
	if(product.price()>=5000) {
		return product.price()- product.price()*0.10;
	}
	else {
		return product.price()-product.price()*0.05;
	}
};
Product  p=new Product(id, name, price);

System.out.println("Final price of the product is :"+productDis.apply(p));
}
}
