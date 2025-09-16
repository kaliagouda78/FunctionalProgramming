package predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo2 {

	public static void main(String[] args) {
		Predicate<String> check=str->str.startsWith("A");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your Name :");
		String str=sc.nextLine();
		System.out.println("Does you name"+str+"Start with A :"+check.test(str));
		sc.close();
	}

}
