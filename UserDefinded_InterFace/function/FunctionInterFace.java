package function;

import java.util.function.Function;

public class FunctionInterFace {

	public static void main(String[] args) {
		Function<Integer, Integer> cube=num->num*num*num;
		System.out.println("cube is "+cube.apply(10));
		Function<Integer, Boolean> check=age->age>=18;
		System.out.println("are you elegable or not :"+check.apply(19));
		
	}

}
