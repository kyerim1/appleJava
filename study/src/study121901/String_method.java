package study121901;

import java.util.Arrays;
import java.util.Scanner;

public class String_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word="i like banana chacha";
		
		// 1. 문자열에서 특정 문자 추출 - charAt()
		char ch = word.charAt(2);
		System.out.println( ch );
		
		Scanner scan = new Scanner(System.in);
		ch = scan.next().charAt(0);
		System.out.println(  ch );
		
		// 2. 문자열 비교 - equals()
		if(  word.equals("i like") )
			System.out.println("같다");
		else
			System.out.println("같지않다");
		
		// 3. 문자열을 byte로 반환 - getBytes() - 파일 불러오기
		byte[] code = word.getBytes();
		System.out.println( Arrays.toString( code ) );
		
		// 4. 문자열에서 특정 문자열의 위치를 리턴 - indexOf()
		 int k = word.indexOf('k');
		 System.out.println( k );
		 int banana = word.indexOf("banana");
		 System.out.println( banana );
		 
		 int a5 = word.indexOf('a', 10);
		 System.out.println( a5 );
		 int cha = word.indexOf("ch", 15);
		 System.out.println( cha );
		 
		 // 5. 문자열의 길이 - length()
		 int len = word.length();
		 System.out.println("문자열 길이 : " + len);
		 
		 // 6. 문자열 변경(치환) - replace()
		 String temp = word.replace("banana chacha", "rescue tayo");
		 System.out.println("원본 : " + word );
		 System.out.println("변경후 : " + temp);
		 
		 // 자바스크립트에서  정규표현식을 이용하여 문자열 변경
		 // 자바에서도 정규표현식을 사용한다.
		 //  [^0-9]
		 // 특수문자제거 [^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]
		 
		 temp = word.replaceAll("a.","c" );
		 System.out.println( temp );
		 
		 temp = "010-1234-5678";
		 temp = temp.replaceAll("[^0-9]", "");
		 System.out.println( temp );
		 
		 // 7. 문자열 추출 - substring
		 
		 temp = word.substring(5);
		 System.out.println( temp );
		 
		 temp = word.substring(7, 15);
		 System.out.println( temp );
		 
		 temp = "skyblue@gmail.com";
		 // 아이디와  포털사이트주소 알아내기
		 String id = temp.substring(0, temp.indexOf("@") );
		 System.out.println("아이디 : "+id);
		 
		 String url = temp.substring( temp.indexOf("@")+1 );
		 System.out.println( url );
		 
		 temp = "대전광역시 중구 중앙로 121번길 20";
		 // 위 주소에서 도시명과  도로명 을 출력하세요
		 String city = temp.substring(0, temp.indexOf(" "));
		 String road = temp.substring( temp.indexOf(" ", city.length()+1)+1  );
		 
		System.out.println(city+"  "+ road);
		
		// 8. 문자열 분리 - split() , 하나의 문자열을 지정한 문자기준으로 배열로 생성,
		String[] str = word.split(" ");
		System.out.println( Arrays.toString( str ));
		temp = "010-1234-5678";
		String password = temp.split("-")[2];
		
		temp = "12 가 4570";
		String[] car = temp.split(" ");
		if( car[2].equals( "4570" ) ) {
			System.out.println("주차비 정산");
		}else if( car[0].equals( "12" ) ) {
			System.out.println( "주차비 정산");
		}
		
		// 9. 대문자, 소문자 변환 - toLowerCase(), toUpperCase()
		temp = word.toUpperCase();
		System.out.println("대문자 : " +temp);
		
		temp = temp.toLowerCase();
		System.out.println("소문자 : " +temp);
		
		// 10. 문자열과 문자열을 결합 - concat()
		word = "내가 좋아하는 노래 : ";
		temp = "바나나 알러지 원숭이";
		String song = word.concat(temp);
		System.out.println( song );
		
		// 11. String 참조변수가 빈값인지 확인( 문자열이 있냐 없냐) - isEmpty()
		System.out.println(  word.isEmpty() );
		
		// 12. 문자열에  특정 문자 또는 문자열 포함 여부 - contains()
		System.out.println(  temp.contains("원숭이")  );
		
		// 13. 특정 문자로 시작, 끝나는지검사 - startsWith() , endsWith()
		System.out.println(  word.startsWith("내가") );
		
	}

}



