package bi_predicate;

import java.util.function.BiPredicate;

public class Bipredicate_Demo1 {

	public static void main(String[] args) {
		BiPredicate<String, Integer>filter=(x,y)->{
			return x.length()==y;
			};
		boolean result=filter.test("Ravi",4 );
		System.out.println(result);
		result=filter.test("Hyderabad", 9);
	}

}
