package lambda_demo;

public class LambdaDemo1 {

	public static void main(String[] args) {
		Vehicle car=()->System.out.println("car is running ");
		car.run();

	}

}
