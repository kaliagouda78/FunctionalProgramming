package predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo1 {

	public static void main(String[] args) {
		Predicate<Integer> intType=age->age>=18;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your age :");
		int age=Integer.parseInt(sc.next());
	System.out.println("Are you Elegeble for vote or not :"+intType.test(age));
	sc.close();
}
}
