package lambda_demo;
interface Print{
	void print();
	int doSum(int x,int y);
	int length(String str);
}
class Display  implements Print{

	@Override
	public void print() {
		System.out.println("Void id print");
		
	}

	@Override
	public int doSum(int x, int y) {
		
		return x+y;
	}

	@Override
	public int length(String str) {
		
		return str.length();
	}
	
}
public class Normal {

	public static void main(String[] args) {
		Print P=new Display();
		    
		     System.out.println( P.doSum(10, 40));
	}

}
