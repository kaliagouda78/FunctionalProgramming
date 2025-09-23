package lab_assignment_2;

import java.util.Scanner;
import java.util.function.Predicate;

record Customer(String name,Double salary,Integer creditScore,Integer age) {
public boolean checkLoanEligibility() {
	if(salary>21000&&creditScore>700&& age>21) {
		return true;
	}
	else return false;
}
}
public class ElegebleCheck {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		Double sal=sc.nextDouble();
		Integer creditScore=sc.nextInt();
		Integer age=sc.nextInt();
	//	Predicate<Customer>customer= (name, sal, creditScore, age)->new Customer(name, sal, creditScore, age)
	}

}
