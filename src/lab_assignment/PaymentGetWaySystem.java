package lab_assignment;

import java.util.Scanner;

interface Payment{
	void processPayment();
	void applyDiscount();

}
class CreditCardPayment implements Payment{

	@Override
	public void processPayment() {
		
		System.out.println("Processing credit card payment...\r\n"
				+ "");
	}

	@Override
	public void applyDiscount() {
		System.out.println("Initiating Credit Card payment.");
		System.out.print("Applying 10% discount for credit card users.\r\n"
				+ "");
	}
	
}
class UPIPayment implements Payment{

	@Override
	public void processPayment() {
		
		System.out.println("Processing UPI payment...");
	}

	@Override
	public void applyDiscount() {
		System.out.print("Initiating UPI payment.\r\n"
				+ "Applying ₹100 cashback for UPI users.");
		
	}
	
}
class PaymentGateway{
	public   Payment  initiatePayment(Payment payment) {
		return new Payment() {

			@Override
			public void processPayment() {
				payment.processPayment();
				
			}

			@Override
			public void applyDiscount() {
				payment.applyDiscount();
				
			}
			
		};
		
	}

}
public class PaymentGetWaySystem {

	public static void main(String[] args) {
		PaymentGateway pay=new PaymentGateway();
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		Payment initiatePayment=null;
		switch(choice) {
		case 1->{
			 initiatePayment = pay.initiatePayment(new CreditCardPayment()  );
			initiatePayment.applyDiscount();
			initiatePayment.processPayment();
}
		case 2->{
		 initiatePayment = pay.initiatePayment(new UPIPayment()  );
		 initiatePayment.applyDiscount();
		 initiatePayment.processPayment();
		}
		default ->System.out.println("invalied Choice");
		}
	}

}
