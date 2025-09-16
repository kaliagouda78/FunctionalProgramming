package com.kalia.type_datatype;
class Box<T>{
	private T data;
	public Box(T data) {
		this.data=data;
	}
	public T getData(){
		return data;
	}
}
public class TypeParameter {

	public static void main(String[] args) {
		Box<Integer> intType=new Box<Integer>(25);
        System.out.println("Integr value is :"+intType.getData());
        Box<Double> dblType=new Box<Double>(12.45);
        System.out.println("Double Value is :"+dblType.getData());
        Box<Character> charType=new Box<Character>('A');
        System.out.println("Charector Type :"+charType.getData());
        Box<String> string=new Box<String>("kalia");
        System.out.println("String Type is :"+string.getData());
        Box<Student> student=new Box<Student>(new Student(1001,"kalia"));
        System.out.println("Student Data is  :"+student.getData());
	}

}
 record Student(int id,String name) {
	 
 }