package java_interface;


interface Request{
	public String getOrder();
}

class Customer{
	protected String menu;
	public Customer(String menu) { this.menu=menu; }
}
//단골 손님
class CustomerA extends Customer implements Request{
	public CustomerA(String menu) { super(menu); }
	public String getOrder() {
		return "손님 A에게 "+menu+"을 준다.";
	}
}
class CustomerB extends Customer implements Request{
	public CustomerB(String menu) {super(menu); }
	public String getOrder() {
		return " 손님 B에게 "+menu+"을 준다.";
	}
}
//식당
class Restaurant{
	public void giveFood(Request res) {
		System.out.println(  res.getOrder() );
	}
}

public class order2 {

	public static void main(String[] args) {
		
		Restaurant owner = new Restaurant();
		Request a= new CustomerA("청국장");
		Request b = new CustomerB("삼겹살");
		owner.giveFood(a);
		owner.giveFood(b);
		
	}
	
	// 식당 주문 시스템을 만드는데  손님에게서 주문요청이 들어오면 어떤 손님이든
	//  getOrder() 메서드로 실행 해야한다.
	
	// 인터페이스는  자바 프로그램 개발에 가이드 라인을 제공 하는 역할 을 한다.
	// 개발에 규칙을 정해놔야 혼돈 없이 개발 할 수 있다.
	// 인터페이스 사용은 협업, 낮은 종속성, 다중 상속을 위해 사용한다.

}




