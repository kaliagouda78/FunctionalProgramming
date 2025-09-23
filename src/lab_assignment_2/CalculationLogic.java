package lab_assignment_2;

import java.util.Scanner;
import java.util.function.Predicate;

public class CalculationLogic {
	public static boolean testPredicate(int x,Predicate<Integer> pred) {
		return pred.test(x);
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your Number :");
	int n=sc.nextInt();
Predicate<Integer>	evenCheck=num->num%2==0;
System.out.println(n+"is even :"+testPredicate(n, evenCheck));
Predicate<Integer>  greaterCheck=num->num>=10;
System.out.println(n+"is greater than 10:"+testPredicate(n, greaterCheck));
Predicate<Integer> isPrime=num->{
	int c=0;
	for(int i=1;i<=n;i++) {
		if(n%i==0)c++;
	}
	if(c==2) {
		return true;
	}
	else return false;
};
System.out.println(n+"is prime :"+testPredicate(n, isPrime));
}
}
