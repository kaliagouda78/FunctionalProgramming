package com.kalia.type_datatype;
interface Length<T>{
	int transfer(T values);
}
public class LengthCheck {

	public static void main(String[] args) {
		Length<String> con=values->values.length();
System.out.println("Length is "+con.transfer("Ram"));
	}

}
