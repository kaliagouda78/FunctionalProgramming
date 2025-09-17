package consumer_interface;

import java.util.function.BiConsumer;

public class ConsumerDemo2 {

	public static void main(String[] args) {
	BiConsumer<String, Integer> printStudent=(name,marks)->System.out.println("Student :"+name+",Marks: "+marks);
	BiConsumer<String, Integer> giveGraceMark=(name,marks)->{
	marks=marks+5;
	System.out.println("updated marks of "+name+" = "+marks);
	};
	String student1 = "Rahul"; int marks1 = 75;
	String student2 = "Sneha"; int marks2 = 82;
	String student3 = "Amit";  int marks3 = 64;
	printStudent.accept(student1, marks1);
	printStudent.accept(student2, marks2);
	printStudent.accept(student3, marks3);
	giveGraceMark.accept(student1, marks1);
	giveGraceMark.accept(student2, marks2);
	giveGraceMark.accept(student3, marks3);
	
			}

}
