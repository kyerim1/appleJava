package data_class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class data_test {

	public static void main(String[] args) {
		
		
		book[] info = new book[10];
		
		try (BufferedReader bf = new BufferedReader(new FileReader("c:/test/book.txt")))
		{
			int i=0;
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				book data = new book(temp[0], temp[1], temp[2]);
				
				info[i] = data;
				i++;
			}
			
		}catch(Exception e) {
			System.out.println("파일 로드및 반환 실패");
			e.printStackTrace();
		}
		
		
		System.out.println( Arrays.toString(info) );
		
	}

}
