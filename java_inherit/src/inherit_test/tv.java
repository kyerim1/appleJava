package inherit_test;

public class tv extends house{

	int ch; //채널
	int vol; //소리
	
	tv(){ // 기본 생성자 메서드
		System.out.println("tv 클래스의 생성자입니다.");
		ch=7;
		vol=15;
	}
	
	tv(String brand){ // 매개변수가 있는 생성자메서드
		super(brand);
	}
}



