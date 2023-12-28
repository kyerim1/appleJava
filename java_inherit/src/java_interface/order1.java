package java_interface;

//
//class Customer{
//	public String request;
//	
//	public void setRequest(String request) {
//		this.request=request;
//	}
//}
//
//// 식당 단골 손님 클래스
//class CustomerA extends Customer{
//	
//}
//class CustomerB extends Customer{
//	
//}
//
//// 식당
//class Restaurant{
//	public void giveFood(CustomerA cusA) {
//		System.out.println("손님 A에게 "+cusA.request+"을 준다");
//	}
//	public void giveFood(CustomerB cusB) {
//		System.out.println("손님 B에게 "+cusB.request+"을 준다.");
//	}
//}


public class order1 {

	public static void main(String[] args) {
		
		Restaurant owner = new Restaurant();
		CustomerA a = new CustomerA();
		CustomerB b = new CustomerB();
		a.setRequest("청국장");
		b.setRequest("촌돼지김치찌개");
		
		owner.giveFood(a);
		owner.giveFood(b);

	}

}
