package study122601;

import java.util.Arrays;

import study122602.tv;

public class java_accsess {

	public static void main(String[] args) {
		
		//book.title="C언어";
		book.cnt=1; // 클래스변수이기때문에 객체생성없이 사용가능
		book bk = new book();
		bk.title="c언어"; // 인스턴스변수는 객체 생성후 사용가능
		book.cnt=2;
		bk.cnt=3; // 클래스의 모든 객체들이 공통으로 클래스변수를 사용할 수 있다.
		
		book.init();
		
		final int num=10;
		//num=20;
		
		final int[]  arr = new int[] {10,20,30};
		
		arr[0]=100;
		//arr = new int[] {20,30,40};
		
		System.out.println( Arrays.toString(arr)  );
		
		book bk1 = new book();
		bk1.title="html과 css";
		
		tv t1 = new tv();
		t1.maker="삼성";
		
	}

}
// 제어자 - 클래스, 변수, 메서드
//  접근제어자 - public, private, protected, default
//   static , final, abstract ,native 등등

// static - '클래스의' 또는 '공통적인' 
//        - static이 붙은 변수나 메서드는 인스턴스(객체)를 생성하지 않고 사용가능
//        - static 변수는 인스턴스 메서드에서 사용 가능 하다.
//        - static 메서드에서는 인스턴스변수 사용불가
//        - static 메서드에서는 오직 static 변수나, static 메서드만 사용 가능
// 		  - static class 내부 클래스에 적용 하여 사용한다.

// final - '마지막의' 또는 '변경될 수 없는'
//       - final을 변수에 붙여주면 상수에 의미가 된다.(초기값 이후에 값 변경 안됨)
//       - final이 붙은 배열은 배열내부의 값 변경은 되지만, 다른 배열로 교체는 불가능
//       - final을 메서드에 붙여주면  해당 메서드는 오버라이딩이 안된다.
//       - final을 class에 붙여주면  상속 할 수 없다.(추상화도 안된다.)

// 접근제어자 
// public - 공공의,  제한없이 사용가능,  패키지가 같지않아도 사용가능
//        - class 에 public 이 붙은 경우  어디에서도 해당 클래스를 사용할 수 있다.
//        - 인스턴스변수, 클래스변수, 인스턴스메서드, 클래스메서드 등  public 이 붙지않으면
//          객체를 생성하여도 사용하는데 제한이 있다.
//
// default - 같은 패키지에서만 사용가능 
// protected - 같은 패키지에서만 사용가능 , 
//           - 다른 패키지라도  상속관계라면 사용가능
// private - 패키지가 같아도 달라도  사용 불가
//         - 어떠한 클래스도 사용 할수 없다.
//         -  오직 해당 클래스 내부에서만 사용가능






