package lab_assignment4;

import java.util.Scanner;
import java.util.function.Consumer;


public class Q1 {
	public static void  modifyValue( int value, Consumer<Integer> con) {
		con.accept(value);
	}
	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter a Number :");
       int a=sc.nextInt();
		 Consumer<Integer> DoubleValue=x->System.out.println("After doubling the value:"+x*2);
		 Consumer<Integer> incValue=x->System.out.println("After incrementing the value by 3:"+(x+3));
		 
		 Consumer<Integer> sqrValue=x->System.out.println("After squaring the value:"+(x*x));
		 
		 modifyValue(a,DoubleValue);
		 modifyValue(a,incValue);
		 if(a<0) {
			 System.exit(0);
		 }
		 modifyValue(a,sqrValue);
		 
	}

}
