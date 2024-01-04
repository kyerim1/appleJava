package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class line {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Stack<String>  stack = new Stack<String>();
//		
//		stack.push("치즈버거");
//		stack.push("한우불고기");
//		stack.push("모짜렐라인더버거");
//		stack.push("데리버거");
//		stack.push("새우버거");
//		
//		System.out.println( stack );
//		
//		System.out.println(  stack.pop() );
//		System.out.println( stack.empty() );
//		System.out.println( stack );
//		System.out.println( stack.peek() );
//		System.out.println( stack.search("데리버거") );
		
		Stack<String> back = new Stack<String>();
		Stack<String> front = new Stack<String>();
		String now="네이버메인";
		
		//  브라우저에서 페이지 이동시 스택에 저장되는 방법 구현
		
		while(true) {
			now = pageMove(back, front, now);	
		}
	}
	
	static String pageMove(Stack<String> back,  Stack<String> front, String now) {
		System.out.print("이동할 페이지 입력(뒤-1, 앞-2) : ");
		String url = scan.nextLine();
		
		if( url.equals("1")  ) {
			if( back.empty() ) {
				System.out.println("방문한 페이지가 없습니다.");
				url=now;
			}else {
				url=back.pop();
				front.push(now);
			}
		}
		else if( url.equals("2")  ) {
			if( front.empty() ) {
				System.out.println("방문한 페이지가 없습니다.");
				url=now;
			}else {
				url = front.pop();
				back.push(now);
			}
		}else {
			back.push(now);
		}
		
		System.out.println("현재 페이지 : "+url);
		System.out.println("\n===========뒤==========");
		System.out.println( back );
		System.out.println("\n===========앞==========");
		System.out.println( front + "\n\n");
		
		
		
		return url;
	}

}

// stack - 선형자료구조이며, FILO ( 첫번째 입력된 값은 마지막에 출력된다.)
//                       LIFO( 마지막에 입력된 값은 첫번째로 출력된다.)
//   계산기, 프로그램의 실행취소및 되살리기, 웹브라우저의 뒤로,앞으로버튼  등등
//  스택에서 입력은 push, 출력 pop 



