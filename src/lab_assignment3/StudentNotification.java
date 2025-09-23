package lab_assignment3;

import java.util.Scanner;
import java.util.function.Consumer;

record  Student(Integer id,String name,String Course) {
	
}
public class StudentNotification {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Consumer<Student> student=stu->{
			System.out.println("Hello "+stu.name()+"!Welcome to the "+stu.Course()+" course.");
		};
		System.out.println("Enter Number of Student :");
		int numberOfStudent=sc.nextInt();
		for (int i=1;i<=numberOfStudent;i++) {
		System.out.println("Enter student Id  :");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student name :");
		String name=sc.nextLine();
		System.out.println("Enter course :");
		String course=sc.nextLine();
		Student student1=new Student(id, name, course);
		student.accept(student1);
		}
	}

}
