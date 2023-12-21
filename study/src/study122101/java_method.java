package study122101;

import java.util.Scanner;

public class java_method {

	static Scanner scan = new Scanner(System.in);
	
	//static - 클래스(static) 메서드에서는  오직 static변수나, static 메서드만 사용 가능
	//        static 메서드에서 인스턴스변수와 인스턴스 메서드는 사용 불가
	
	public static void search( student[] std , String  name ) { // 이름으로 검색하여 성적 조회
		boolean isStd = false;
		
		for( int i=0; i<std.length; i++) {
			if( std[i].name.equals(name) ) {
				System.out.println( std[i] );
				isStd=true;
			}
		}
		if( !isStd )
			System.out.println("등록되지 않은 학생 입니다.");
	}
	
	public static void main(String[] args) {
		
		student[] std = new student[6]; // 참조변수 6개 공간 생성
		std[0] = new student("이순신",86,95,67);
		std[1] = new student("김유신",94,84,55);
		std[2] = new student("장보고",78,34,76);
		std[3] = new student("이성계",98,55,46);
		std[4] = new student("정약용",100,99,87);
		std[5] = new student("문익점",76,56,100);
		
		System.out.print("조회할 학생 이름 입력 : ");
		String name = scan.nextLine();
		
		search( std, name  );
		
		
		
//		std[0].calc();
		
		//System.out.println(  std[0] );
		
//		student s = new student(); 
//		
//		student std = new student("이순신",86,95,67); //student클래스 객체를 생성해서 참조변수 std에 저장
////
//		System.out.println( std );
//		std.name="이순신";
//		std.kor=86;
//		std.mat=95;
//		std.eng=67;

	}

}
