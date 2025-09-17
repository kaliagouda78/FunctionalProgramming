package suppiler_interface;

import java.util.function.Supplier;

public class Demo1 {

	public static void main(String[] args) {
		Supplier<Integer> intype=()->10+20;
		System.out.println(intype.get());
        Supplier<String> string=()->"Aswini".toLowerCase();
        System.out.println(string.get());
	}

}
