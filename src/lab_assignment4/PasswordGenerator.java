package lab_assignment4;

import java.util.Random;
import java.util.function.Supplier;

public class PasswordGenerator {

	public static void main(String[] args) {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 String lower = "abcdefghijklmnopqrstuvwxyz";
		 String digits = "0123456789";
		 String special = "@#$%!&*";
		 String totalCharacter = upper+lower+digits+special;
		 Supplier<String> passwordSuplier=()->{
			Random rr= new Random() ;
			String password="";
			for(int i=1;i<=8;i++) {
			int index=rr.nextInt(totalCharacter.length());	
			password+=totalCharacter.charAt(index);
			}
			return password;
		 };
		 System.out.println(passwordSuplier.get());
	}

}
