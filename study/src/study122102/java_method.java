package study122102;

import java.util.Scanner;

public class java_method {

	static void list_print( music[] mylist) {
		for( music obj : mylist) {
			System.out.println( obj );
		}
	}
	
	static void song_search(String keyword, music[] mylist) { // 가수 또는 노래제목 으로 검색
		
		boolean issong = false;
		for( music obj : mylist) {
			if(obj.singer.equals(keyword) || obj.title.equals(keyword) ) {
				System.out.println( obj );
				issong=true;
			}
		}
		if(	!issong	)
			System.out.println("검색 결과 없음");
	}
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		music[] mylist = new music[] {
			new music("폴킴","있잖아",328), new music("탑현","호랑수월가",441),
			new music("다비치","슬픈다짐",332),new music("토이","세사람",445),
			new music("정재욱","들리나요",359),new music("다비치","사랑 사랑아",332),
			new music("황치열","어찌 잊으오",442),new music("멜로망스","좋은날",529),
			new music("조정석","아로하",405),new music("아이유","내 손을 잡아",315),
		};
		
		list_print(mylist);
		
		System.out.print("가수 또는 노래제목 : ");
		String keyword = scan.nextLine();
		song_search(keyword,mylist);
	}

}



