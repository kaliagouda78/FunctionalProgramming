package lambda_demo;

interface Adder {
    int add(int x, int y);
}

public class LamdaDemo2 {
    public static void main(String[] args) {
        
        Adder add = (a, b) -> {
            int sum = a + b;
            System.out.println("Sum is : " + sum);
			return sum;
           
        };

        add.add(10, 19);
    }
}
