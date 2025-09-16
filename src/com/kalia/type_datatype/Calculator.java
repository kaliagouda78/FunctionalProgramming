package com.kalia.type_datatype;
interface Calculatorr<T>{
	void caluculate(T a,T b);
}
public class Calculator {

	public static void main(String[] args) {
		Calculatorr<Integer> sum=(a,b)->System.out.println("Sum is :" +(a+b));
		sum.caluculate(19, 50);
		Calculatorr<Double> mul=(a,b)->System.out.println("Mul is  :"+(a*b));
		mul.caluculate(12.00, 12.0);
	}

}
