package thread_test1;

public class test5 {

	public static void main(String[] args) {
		Runnable r = new myApp();
		
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.setName("1번");
		th2.setName("2번");
		
		th1.start();
		th2.start();

	}

}

//  async  json 불러오는함수  ,   await 실제 json파일 읽는 함수

class Bank{
	private int myMoney = 1000000;
	public int getMyMoney() {
		return myMoney;
	}
	// 쓰레드 동기화 임계영역 설정 과 락 이 필요하다.
	// 임계영역 - 둘 이상의 쓰레드가 동시에 접근해서는 안되는 코드 부분
	// 쓰레드가 임계영역에 접근하면 해당 쓰레드는 락을 가지게 된다.
	// 해당 쓰레드가 락을 반납하기 전까지는 다른 쓰레드는 임계영역에 접근 하지 못한다.
	// 메서드의 반환 타입 앞에 synchronized를 붙이거나  
	// 특정코드를 블럭 지정 한다.
	//  synchronized(this){  코드  }
	
	// withdraw 메서드 임계영역 설정
	public synchronized boolean withdraw(int money) {
		//계좌 잔고가 출금할 금액보다 크거나 같으면 출금 가능
		if(myMoney >= money) {
			try { Thread.sleep(1000); }
			catch(Exception e) {}
			
			myMoney -= money;
			
			return true;
		}
		return false;
	}
}

class myApp implements Runnable{
	Bank my = new Bank();
	
	@Override
	public void run() {
		while( my.getMyMoney() > 0 ) {
			int money = (int)(Math.random()*5+1)*10000;
			
			boolean fail = my.withdraw(money);
			
			String thName = Thread.currentThread().getName();
			if( fail) {
				
				System.out.printf("쓰레드 : %s  출금 : %d원  잔고 : %d원\n",
						thName, money , my.getMyMoney() );
				
			}else {
				System.out.println( thName +" : 잔액부족");
			}
			
		}
	}
}






