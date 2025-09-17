package bi_consumer;
import java.util.function.BiConsumer;

public class BiConsumerDemo1 {

    public static void main(String[] args) {
        BiConsumer<Integer, String> updateValue = (num2, str) -> {
            num2 = num2 * 10;
            str = str.toUpperCase();
            System.out.println("Updated Detail: " + num2 + " , " + str);
        };

        int num2 = 12;
        String text = " nit";
        updateValue.accept(num2, text);

        System.out.println("Original Value: " + num2 + ", " + text);
    }
}

