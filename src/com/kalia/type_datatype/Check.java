package com.kalia.type_datatype;
interface Checker<T>{
	boolean test(T values);
}
public class Check {

	public static void main(String[] args) {
	Checker<String>check=values->values.charAt(0)=='A';
	System.out.println(check.test("Kalia"));

	}

}
