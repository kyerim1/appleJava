package exception_ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class java_exception {
	
	static Scanner scan = new Scanner(System.in);
	
	static String myAge(String birth) throws StringIndexOutOfBoundsException{
		//Date today = new Date();  
		// 날짜 다루는 클래스, getXxx() 메서드로 날짜시간가져오기 가능
		
		Calendar today = Calendar.getInstance();
		
//		System.out.println("년도 : "+  today.get( Calendar.YEAR )  );
//		System.out.println("월 : "+ today.get(Calendar.MONTH )  );
//		System.out.println("일 : "+ today.get(Calendar.DATE) );
//		
//		System.out.println("올해 주차 : "+ today.get(Calendar.WEEK_OF_YEAR ) );
//		
//		System.out.println("요일(1-일요일) : "+ today.get(Calendar.DAY_OF_WEEK));
//		
//		today.set(2020,1,1);
//		System.out.println("이달의 마지막 날 : "+today.getActualMaximum(Calendar.DATE));		

		int year = today.get(Calendar.YEAR);
		String age =null;

		// throw  - 예외(오류)를 발생시키는 방법
		//   throw를 가지고 있는 메서드는 반드시 throws 가 있어야 한다.
		//   throw를 통해 해당 메서드가 어떤 오류를 안고 있는지 인지 시켜줄수 있고, 예외처리를 강요한다.
		//   예외 처리에 대한 관리를 용이하게 해준다.
		
		// throws - 예외를 넘겨주는 방법
		
		if(birth.length() != 8 ) { //입력한 생년월일이 8자리가 아니라면
			throw new StringIndexOutOfBoundsException("method:myAge - 생년월일은 8자리 입력하세요");
		}
		if( !birth.matches("[+-]?\\d*(\\.\\d+)?") ) {
			throw new NumberFormatException("method:myAge - 숫자만 입력하세요");
		}
		
		int myYear = Integer.parseInt(  birth.substring(0, 4)  );
	
		age= (year-myYear) + "세";
		return age;
	
		
//		finally { // try구문에서 오류가 발생하거나 발생하지 않아도 무조건 실행되는 구문
//			return "0세";
//		}
		
		
	}
	
	public static void main(String[] args) {
		
		// 자동 자원 반환 예외처리 - 파일열기와 같은 외부 파일(데이터)를 사용하게되는경우
		//                      사용한 메모리와 cpu 등등을 close를 통해 반환해야한다.
		//                     자동자원반환 예외처리는 코드의 복잡성을 줄여준 예외처리이다.
		//  try ( 파일열기 ){
		//  }catch(예외클래스 ) {
		//  }
		
		//BufferedReader bf=null;
		
		try (BufferedReader bf = new BufferedReader(new FileReader("c:/test/book.txt"))  )
		{
			
			while( true) {
				String line = bf.readLine();
				if( line==null) break;
				System.out.println( line );
			}
			
			
		}catch( Exception e) {
			System.out.println("파일 로드 및 반환 실패");
		}
		
//		try {
//			bf = new BufferedReader(new FileReader("c:/test/book.txt") );
//		
//			System.out.println( bf.readLine() );
//			System.out.println( bf.readLine() );
//			
//		}catch(Exception e) {
//			System.out.println("파일읽기 실패");
//		}finally {
//			try {
//				bf.close();
//			}catch(Exception e) {
//				System.out.println("파일 닫기 실패");
//			}
//		}
		
//		try {
//			
//		}catch(Exception e) {
//			
//		}
		
//		String birth=null;
//		
//		System.out.print("생년월일 : ");
//		birth = scan.nextLine();
//		
//		try {
//			String age = myAge(birth);
//			System.out.println( age );
//		}catch(Exception e) {
//			System.out.println(  e.getMessage()  );
//			e.printStackTrace();
//		}
		
//		String name=null;
//		int score=0;
//		int[] num = {};
//		try {
//			score=scan.nextInt();
//			
//			System.out.println("이름 : "+ name.concat("님") );
//			System.out.println( score/ num.length);
//			
//		}catch(java.lang.NullPointerException n) {
//			System.out.println("이름을 입력하세요");
//			
//		}catch(java.lang.ArithmeticException a) {
//			System.out.println("성적을 입력하세요");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.print("정상 실행");
		
		
		
		
		
		
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
