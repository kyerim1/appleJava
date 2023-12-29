package exception_ex;

import java.util.Scanner;

public class java_exception {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String name=null;
		int score=0;
		int[] num = {};
		try {
			score=scan.nextInt();
			
			System.out.println("이름 : "+ name.concat("님") );
			System.out.println( score/ num.length);
			
		}catch(java.lang.NullPointerException n) {
			System.out.println("이름을 입력하세요");
			
		}catch(java.lang.ArithmeticException a) {
			System.out.println("성적을 입력하세요");
		}
		
		
		
		
		
//		try {
//			String name;
//			name = scan.nextLine();
//			System.out.println( name.charAt(0) );
//		}catch( Exception  e  ) {
//			System.out.println("이름을 입력하세요");
//		}
		
		
//		try {
//			
//			int num=10;
//			
//			System.out.println(  num/0  );
//			
//		}catch( java.lang.ArithmeticException  e ) {
//			 System.out.println( e.getMessage() );
//			 e.printStackTrace();
//			 System.out.println("0으로 나누기 할 수 없습니다.");
//		}
//		System.out.println(  "프로그램 종료");
	}

}
