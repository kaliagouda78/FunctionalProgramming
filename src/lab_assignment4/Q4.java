package lab_assignment4;

import java.util.Random;
import java.util.function.Supplier;

public class Q4 {

	public static void main(String[] args) {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 String lower = "abcdefghijklmnopqrstuvwxyz";
		 String digits = "0123456789";
		 String special = "@#$%!&*";
		 String totalCharacter = upper+lower+digits+special;
		 
		 Supplier<String>  passwordSupplier  =  ()->
		 {
			 String password = "";
			 
			 Random rr = new Random();
			 
			 for(int i=0; i<8; i++)
			 {
				 int index = rr.nextInt(totalCharacter.length());
				 password += totalCharacter.charAt(index);
			 } 
			 
			 
			 return password;
		 };
		 
		 String pwd = passwordSupplier.get();
		 System.out.println("Generated Password :"+pwd);
		 
		 

	}

}
