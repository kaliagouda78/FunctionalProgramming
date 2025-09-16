package com.kalia.type_datatype;
 interface HotDrink{
	void prepare();
}
 class DrinkFactory{
	 public static HotDrink getTea(){
		return new HotDrink() {
			
			@Override
			public void prepare() {
				System.out.println("irani tea is preparing");
				
			}
		};
		 
	 }
	 public static HotDrink getCofee() {
		 return new HotDrink() {
			
			@Override
			public void prepare() {
				System.out.println("Filter cofee is preparing now");
				
			}
		};
	 }
 }
 
public class AnonymousInnerClass_Demo2 {

	public static void main(String[] args) {
		HotDrink tea=DrinkFactory.getTea();
		tea.prepare();
		HotDrink coffee=DrinkFactory.getCofee();
		coffee.prepare();
	}

}
