package unary_operator;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class UranaryDemo2 {

	public static void main(String[] args) {
	  UnaryOperator<Double> increamentSal=sal->sal*0.10;
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Ebter Your Sal :");
	  double sal=Double.parseDouble(sc.next());
	  System.out.println("After inrcreamet yourSalary Is :"+(increamentSal.apply(sal)+sal));
	}

}
