package cafe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import customer.member;

public class file {

	public static List<member> member_load(){
		
		List<member> list = new ArrayList<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/member.txt")))
		{
			
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				member data =new member(temp[0], temp[1],temp[3], temp[2],  temp[4], 
						i(temp[5]) );
				list.add(data);
			}
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("member 파일 로드 실패");
		}
		
		return null;
	}
	
	
	public static HashMap<String, menu> menu_load() {
		
		HashMap<String, menu> list = new HashMap<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/menu.txt"))){
			
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				
				menu data = new menu(temp[0] , i(temp[1]) , i(temp[2]), i(temp[3]),
						i(temp[4]), i(temp[5]) , 
						temp[6].equals("커피") ? Category.커피 : temp[6].equals("음료") ?
								Category.음료 : Category.빽스치노
						);
				list.put( temp[0]  ,data);
				
			}
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("menu 파일 로드 실패");
		}
		
		
		return null;
	}
	
	public static int i(String number) {
		return Integer.parseInt(number);
	}
	
	
}




