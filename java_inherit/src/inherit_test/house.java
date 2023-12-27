package inherit_test;

public abstract class house {
	
	public static int makedate=20231209; //클래스 변수
	
	public boolean onoff;
	String brand;
	public int sn=10000 ; // 시리얼넘버
	
	protected house(){ // 기본 생성자 메서드
		onoff=false;
		System.out.println("나는 부모 house 클래스 생성자");
	}
	
	protected house(String brand){
		this.brand= brand;
	}
	
	public abstract void power();  // 추상 메서드
	
	// 추상 메서드를 가진 클래스는 반드시 추상 클래스가 되어야 한다.
	
	// 부모클래스가 추상클래스라면 자식클래스는 부모의 모든 추상메서드를 구현해야한다.
	// 부모에게 받은 추상메서드를 자식이 구현하지않을꺼라면 자식클래스는 추상클래스가되어야한다.
	// 추상 클래스는  객체 생성이 안된다.
	//추상 메서드는  내용이 없는 메서드라서 메모리 공간을 할당 받지 못한다.
	// 메모리 공간을 할당 받지 못하기때문에 추상메서드를 가진 클래스는 객체 공간 할당 못받는다.
}





