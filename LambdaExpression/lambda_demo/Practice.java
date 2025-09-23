package lambda_demo;
class Box<T>{
	private  T a;
   public void square(T a) {
	   this.a=a;
	   System.out.println("The square of one number is :"+a);
   }
}
public class Practice {

	public static void main(String[] args) {
		Box<Integer> c1=new Box();
		c1.square(12);

	}

}
