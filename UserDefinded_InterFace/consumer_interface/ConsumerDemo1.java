package consumer_interface;

import java.util.function.Consumer;

public class ConsumerDemo1 {

	public static void main(String[] args) {
		Consumer<Integer> intType=num->System.out.println("Integer Value is :"+num);
                 intType.accept(10);
        Consumer<String> string =str->System.out.println("String value is "+str);
                 string.accept("Subham");
        Consumer<Double> dblType=dbl->System.out.println("Double vaalue is :"+dbl);
        		dblType.accept(13.86);
        
        		
	}

}
record Student(int id,String name) {
	
}