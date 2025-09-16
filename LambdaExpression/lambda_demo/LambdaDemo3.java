package lambda_demo;
interface Runnable{
	int getLength(String str);
	
}
public class LambdaDemo3 {

	public static void main(String[] args) {
		Runnable length=str->str.length();
        System.out.println("the length is :"+length.getLength("kalia"));
	}

}
