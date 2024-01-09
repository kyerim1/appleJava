package cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import customer.Order_History;
import customer.member;

public class Order_Counter {

	static Scanner scan = new Scanner(System.in);
	static HashMap<String,menu> Menu = null;
	static List<member> buyer = null;
	
	static member user=null; // 로그인 성공한 회원 객체 저장 참조변수
	
	public static void main(String[] args) {
		Menu = file.menu_load();
		buyer = file.member_load();
		
		// 스토리 - 회원이 로그인하여 주문(모바일또는 PC) 한다.
		// 로그인부터 주문 과정까지를 제작

		user = login();
		
		//관리자 로그인시  관리자메뉴로 만 보이게 주문안됨
		if(user.getMid()==1000000) {
			System.out.println("1. 판매 내역");
			System.out.println("2. 메뉴 관리");
			System.out.println("3. 재고 관리");
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			history_list();
			
		}else {
			// 주문
			HashMap<Category, Set<menu>> cafeMenu = classTask();
			Order.kiosk(cafeMenu);
		}
	}
	
	private static void history_list() {
		// 데이터베이스 사용(연결)
		// 1. 데이터베이스 드라이버 로드
		// 2. 데이터베이스 connection - 데이터베이스 url, 데이터베이스 계정
		//                            데이터베이스 계정비밀번호
		// 3. 쿼리문(query 또는 sql질의문) 작성
		// 4. 쿼리문 전달 - Statement, PreparedStatement
		// 5. 쿼리문의 결과 를 받아야 한다면 ResultSet 필요
		
		try {// 1. 데이터베이스 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		
		// 2. 데이터베이스 connection - 데이터베이스 url, 데이터베이스 계정
				//                            데이터베이스 계정비밀번호
		
		Connection conn=null;
		try {
			String url="jdbc:mysql://localhost:3306/javaTest";
			String user="javaTest";
			String password="123456";
			conn = DriverManager.getConnection(url,user,password);
			
		}catch(SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pt = null;
		ResultSet res=null;
		
// select 컬럼명 from 테이블명;  
// select * from 테이블명 -> 모든 컬럼을 조회 하기
		
		String sql="select * from history";
		List<Order_History> list = new ArrayList<>();
		try {
			
			pt = conn.prepareStatement(sql);
			res = pt.executeQuery(); // 쿼리전달하고 결과 받기
			
			while(res.next()) {
				Order_History data = new Order_History(
					res.getInt("num"), res.getString("customer"),
					res.getString("menu"), res.getInt("price")
				);
				list.add(data);
			}
			
		}catch(SQLException e) {
			System.out.println("데이터 조회 실패");
			e.printStackTrace();
		}
		
		// 컬렉션 프레임워크 전용 순회 인터페이스 - Iterator
		Iterator<Order_History> it = list.iterator();
		while( it.hasNext() ) {
			System.out.println( it.next());
		}
		
	}
	
	public static HashMap<Category, Set<menu>> classTask(){
		
		Set<menu> 커피 = new HashSet<>();
		Set<menu> 음료 = new HashSet<>();
		Set<menu> 빽스치노 = new HashSet<>();
		
		Iterator<String> it = Menu.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(  Menu.get(key).getType()==Category.커피  ) {
				커피.add(Menu.get(key));
			}else if( Menu.get(key).getType() == Category.음료) {
				 음료.add(Menu.get(key));
			}else if( Menu.get(key).getType() == Category.빽스치노 ) {
				빽스치노.add(Menu.get(key));
			}
		}
		
		HashMap<Category, Set<menu>> map = new HashMap<Category, Set<menu>>();
		
		map.put(Category.커피, 커피);
		map.put(Category.음료, 음료);
		map.put(Category.빽스치노, 빽스치노);
		
		
		return map;
	}
	
	
	
	public static member login() {
		System.out.println("\n==========로그인=========\n");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		member temp = new member(id,pw);
		int idx=0;
		
		if(  (idx=buyer.indexOf( temp )) != -1   ) { // 아이디와 비밀번호가 일치하면 
			
			System.out.println("로그인 성공");
			return buyer.get( idx );
			
		} 
			// 아이디 또는 비밀번호가 맞지않으면
			System.out.println("로그인 실패");
		return login();
		
		
		// ArrayList에 저장되어있는 객체들과  비교를 하기위해서는 
		//  반복문을 통해 객체 하나씩 가져와서  값 비교를 해준다.
		//  또는  ArrayList에 저장된 객체의 클래스에 비교 하기위 한 관련 메서드를 구현한다.(equals)
	}
	

}





