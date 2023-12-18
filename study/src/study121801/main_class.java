package study121801;

import java.util.Arrays;

public class main_class {

	public static void main(String[] args) {
	
		// 자바스크립트 - let a = new Array(10);
		//             let b = [10,20,30,40];
		//       a.push(3123);   b.push(233);
		
		int[] arr1 = {101,20};
		
		System.out.println( arr1[0] );
		
		int[] arr2 = new int[10];
		// new int[10]
		// (new)새로운공간  int(정수타입)[10](10공간연속으로생성)
		
		for( int i=0; i<arr2.length; i++ ) {
			arr2[i]= i*10;
		}
		System.out.println( arr2[2] );
		
		for( int i=0; i<arr2.length; i++) {
			System.out.println( arr2[i] );
		}
		
		// 자바에서 기본 배열을 생성하여 다룰때
		// 배열에 저장하 데이터 정하기( 저장 데이텅 따라 데이터 타입 정해야함)
		// 몇개의 데이터를 저장할것인지 갯수 정하기
		// 타입과 갯수에 맞는 배열 생성 
		// 타입 - 문자열,  갯수-7
		// String[] names = new String[7];
		
		// 10명의 학생 성적이 저장 된 배열 만들기
		int[] score = new int[10];
		
		for(int i=0; i<score.length; i++) {
			score[i] = (int)(Math.random()*51)+50;
		}
		System.out.println( Arrays.toString(score) );
		
		Arrays.sort(score);
		System.out.println(Arrays.toString(score) );
		
		// 두개의 배열에 저장된값을 하나의 배열로 합치기
		int[] a= {10,20,30,40};
		int[] b= new int[] {11,22,33,44};
		int[] c = new int[8];
//		for( int i=0; i<a.length; i++) {
//			c[i] =a[i];
//			
//			c[i+4] = b[i];
//		}
// arraycopy(복사대상배열 , 복사배열시작인덱스 , 복사저장할배열, 저장위치, 몇개복사)
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, 4, b.length);
		
		System.out.println( Arrays.toString(c) );
		
		
		int[] data = {170,168, 182, 174, 175, 169, 177};
		// data 배열에는 3학년1반의 키가 저장 되어 있다.
		// 키가 175이상 만 출력 하세요.
		
		for( int i=0; i< data.length; i++) {
			if( data[i] >= 175)
				System.out.println("175이상학생 - "+(i+1)+"번째 학생 키 :"+ data[i] );
		}
		
		
		
	}

}





