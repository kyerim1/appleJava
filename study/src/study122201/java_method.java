package study122201;

import java.util.Scanner;

public class java_method {
	static Scanner scan = new Scanner(System.in);
	static mart[] mart_list;
	
	public static void main(String[] args) {
		
		mart_init();  // 제품등록이 첫번째 실행 되어야 한다.  
		
		buyer 계림 = buyer_enroll(); // 구매자 등록 (buyer 클래스 객체 생성)
		
		put(계림); // 물건을 구매하기 위한 메서드, 더이상 구매하지않아야 메서드가 종료된다.
		
		buy(계림);
		
		
	}
	static void buy( buyer 계림) {
		while(true) {
			System.out.println( 계림 );
			
			System.out.print("장바구니의 물건들을 결제 하시 겠습니까?(y/n) : ");
			char yn = scan.nextLine().charAt(0);
			if( yn=='y' || yn=='Y') { //현재 장바구니의 모든물건 구매시
				계림.payment();
				break; // 결제 완료 하면 buy 메서드 종료
			}else { // 결제 보류 - 장구니에서 빼기 
				계림.basket_remove();
			}
		}
	}
	
	
	static void put( buyer 계림 ) {
		
		while(true) {
			
			System.out.println("\n=============== 목록 =============== \n");
			view();
			System.out.print("물건의 번호를 입력하세요(0-구매중단) : ");
			int num = scan.nextInt();
			scan.nextLine();// 숫자 다음에 문자열 입력시 입력버퍼를 비워야 한다.
			
			if( num== 0) break; // 구매중단 하면  while문 종료
			if( !(num>=1 && num <= mart_list.length) ) 
				continue; // 제품번호를 잘못입력시 다시 반복문 실행;
			
			계림.basket_add( mart_list[num-1] ); //장바구니 크기 증가 - 두번째 물건을 담을때부터
			
			
			System.out.print("장바구니 확인 하시겠습니까? (y/n) : ");
			char yn = scan.nextLine().charAt(0);
			if( yn == 'y' || yn == 'Y') {
				System.out.println( 계림 );
			}
		}
	}
	

	
	
	static buyer buyer_enroll() {
		
		int num = (int)(Math.random()*40000)+10000;
		System.out.print("구매자 성함을 입력하세요 : ");
		String name = scan.nextLine();
		
		buyer 전계림 = new buyer(num, name);
		전계림.basket= new mart[1]; 
		// 장바구니 공간 1개 생성 - 추후 제품을 장바구니에 담으면서 늘어나게 변경
		return 전계림;
	}
	
	static void view() {
		for(int i=0; i< mart_list.length; i++) {
			System.out.println( (i+1) +". " + mart_list[i] );
		}
	}
	
	static void mart_init() {
		mart_list= new mart[] {
			new mart("고추참치",2890, "통조림",2100 ) , new mart("홈런볼",1300, "과자",4231),
			new mart("오이비누4묶음",5890,"비누",450), new mart("신라면1봉지",4300,"라면",5234),
			new mart("짜파게티1봉지",6430,"라면",5132), new mart("햇반(6개)",6700,"즉석식품",312),
			new mart("비비고육개장",1560,"즉석식품",1145), new mart("야채참치",2450,"통조림",3123),
			new mart("골뱅이",2710,"통조림",1365),new mart("먹태깡",1350,"과자",4615),
			new mart("샤토마니",30000,"와인",128), new mart("발비 소프라니",31000,"와인",1232)
				
		};
		
	}
	
	
}



