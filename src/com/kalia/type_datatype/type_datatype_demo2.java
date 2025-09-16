package com.kalia.type_datatype;
interface Container<T>{
	boolean check(T num);
}
public class type_datatype_demo2 {

	public static void main(String[] args) {
		Container<Integer> intTYpe=num->num%2==0;
		System.out.println(intTYpe.check(10));
		

	}

}
