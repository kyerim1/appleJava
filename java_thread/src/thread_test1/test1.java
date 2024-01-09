package thread_test1;

public class test1 {

	public static void main(String[] args) {
		
		myThread th1 = new myThread();
		th1.start();  //쓰레드 실행
		
		for(int i=1; i<=10; i++) {
			System.out.println("main메서드 "+ i);
			try {  Thread.sleep(1000);
			}catch(Exception e) {}
		}
		
		Runnable th2 = new thread2();
		Thread th22 = new Thread(th2);
		th22.start();
		
	}

}

class thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("나는 인터페이스로 작업한 쓰레드일껄?");
	}
	
}

class myThread extends Thread{
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("나는 쓰레드");
			try {  Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
}


// 프로세스 - cpu에의해 실행중인 프로그램
//          프로그램에 대한 정보를 가지고 있다. 
//  쓰레드 - 프로세스 안에서 실질적으로 실행 되는 단위
//  
//  단일쓰레드 - 하나의 작업만 이루어 지는 프로그램, 순차적 실행
// 멀티 쓰레드 - 여러 작업을 동시에 실행 시키는 프로그램, 비동기
// 멀티 쓰레드 사용시  공유 자원에대해 주의 해야한다.
// 공유 자원 - 


// 쓰레드 관련 메서드
// run() : 쓰레드의 실행코드가 작성되는 메서드 - 쓰레드 stack first input
// start() : 쓰레드가 시작되도록 요청하는 메서드 - run 메서드를 호출한다.
// sleep(밀리세컨드) : 지정한 시간동안 현재 쓰레드를 일시 중지 시킨다.
// join() : 현재 쓰레드가 끝날때 까지 기다린다.
// yield() : 현재 쓰레드의 실행 시간을 다른 쓰레드에게 양보한다.

// 데몬 스레드 - 주 쓰레드의 작업을 보조 하는 쓰레드
//            주 쓰레드가 종료 되면 강제적으로 종료된다.




