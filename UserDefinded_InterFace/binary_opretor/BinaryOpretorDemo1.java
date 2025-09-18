package binary_opretor;

import java.util.function.BinaryOperator;

public class BinaryOpretorDemo1 {

	public static void main(String[] args) {
		BinaryOperator<Integer> add=(a,b)->a+b;
		System.out.println("Sum of Two Number :"+add.apply(10, 30));
		

	}

}
