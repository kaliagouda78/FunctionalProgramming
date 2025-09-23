package lab_assignment4;
import java.util.Scanner;
import java.util.function.Consumer;


public class Q3 {
	public static void  modifyValue( int value, Consumer<Integer> con) {
		con.accept(value);
	}
	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter a Number :");
       int a=sc.nextInt();
       
		 Consumer<Integer> DoubleValue=x->System.out.println("After adding 5:"+(x+2));
		 Consumer<Integer> incValue=x->System.out.println("After multiplying by 2:"+(x*2));
		 
		 Consumer<Integer> sqrValue=x->System.out.println("After subtracting 3:"+(x-3));
		 System.out.println("Original value: "+a);
		 modifyValue(a,DoubleValue);
		 modifyValue(a,incValue);
		
		 modifyValue(a,sqrValue);
		 
	}

}