package unary_operator;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo1 {

	public static void main(String[] args) {
	UnaryOperator<Integer> cube=num->num*num*num;
	System.out.println("cube of given Number :"+cube.apply(10));
    UnaryOperator<String> concatnation=str->str.concat(" ram");
    System.out.println("Cancate of given String "+concatnation.apply("Sita"));
	}

}
