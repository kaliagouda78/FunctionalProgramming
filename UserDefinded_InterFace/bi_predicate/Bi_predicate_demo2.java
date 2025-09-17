package bi_predicate;

import java.util.function.BiPredicate;

public class Bi_predicate_demo2 {

	public static void main(String[] args) {
		BiPredicate<String,String > loginValidator =(username,password)->!username.isEmpty()&&password.length()>=8;
		Boolean loginValidatorR=loginValidator.test("kalia Gouda", "kalia1234");
		System.out.println("you are valid user or not ?"+loginValidatorR);
		}

}
