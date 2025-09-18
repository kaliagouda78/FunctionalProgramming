package bi_functional;

import java.util.function.BiFunction;

public class BiFunctionlDemo1 {

	public static void main(String[] args) {
		BiFunction<String, String, String> returnStringType=(str1,str2)->str1+str2;
		System.out.println("str_conn :"+returnStringType.apply("hello", "java"));
		BiFunction< String, String,Integer> returnIntegerType=(Str1,Str2)->Str1.length()+Str2.length();
		System.out.println("Length of two word is :"+returnIntegerType.apply("kalia", "Gouda"));	
	}

}
