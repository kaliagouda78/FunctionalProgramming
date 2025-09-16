package lab_assignment;

public class InterfaceImplementationByUsingAnonymous{
    public static void main(String [] args){
    PrinterDemo p=new PrinterDemo();
    p.getPrinter().print();
   
    }
}
interface Printer {
void print();

}
class  PrinterDemo {
public Printer getPrinter(){
    return new Printer(){
  public void print(){
    System.out.println("Hello from Printer implemented using Anonymous Inner Class!");
  }
    };
}
}