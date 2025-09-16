package com.kalia.type_datatype;
interface predictable{
	boolean test(Integer num);
}
public class PredictAble {

	public static void main(String[] args) {
		predictable p=num->num%2==0;
		System.out.println(p.test(47));

	}

}
