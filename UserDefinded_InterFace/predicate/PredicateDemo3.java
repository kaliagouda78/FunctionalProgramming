package predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo3 {

	public static void main(String[] args) {
		Predicate<String> name=str->str.equals("Ram");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your Name :");
		String str=sc.nextLine();
		System.out.println("Are your Ram :"+name.test(str));

	}

}
