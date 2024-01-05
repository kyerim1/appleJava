package cafe;

import java.util.List;

import customer.member;

public class Order_Counter {

	static List<menu> Menu = null;
	static List<member> buyer = null;
	
	public static void main(String[] args) {
		Menu = file.menu_load();
		buyer = file.member_load();
		
		System.out.println(  buyer.get(0).getId()  );

	}
	

}
