package a;

public class card {
	
	static 조작카드 a = new 조작카드(); //클래스
	
	static int height=30; // 클래스변수
	static int width=17; // 클래스변수
	
	int number;  // 인스턴스변수
	String type; //인스턴스변수
	
	static void draw() {  // 클래스메서드
		System.out.println("카드틀 제작");
	}
	void make() { //인스턴스 메서드 
		System.out.println("카드만들기");
	}
}
