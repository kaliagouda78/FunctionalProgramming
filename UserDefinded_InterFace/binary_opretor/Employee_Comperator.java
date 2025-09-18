package binary_opretor;

import java.util.Comparator;
import java.util.function.BinaryOperator;

record Employee(String name,double sal) {
  public Employee{
	  if(name.isEmpty()||name.equals(null)||sal<=0) {
		 System.err.println("Employee is Invalid"); 
		 System.exit(0);
		 
	  }
}
@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
}

public class Employee_Comperator {

	public static void main(String[] args) {
	BinaryOperator<Employee>maxSalary=BinaryOperator.maxBy(Comparator.comparingDouble(e -> e.sal()));	
	Employee e1 = new Employee("Sita", 50000);
    Employee e2 = new Employee("Ram", 60000);

    Employee higherPaid = maxSalary.apply(e1, e2);

    System.out.println("Higher Paid Employee: " + higherPaid);
	}

}
