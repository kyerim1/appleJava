package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class parent_dao {
	protected Connection conn=null; //접속
	protected Statement st=null; // sql질의문
	protected PreparedStatement pt =null; //Sql질의문
	protected ResultSet rs=null; // 결과 

	public parent_dao() {
		DriverLoad();
		ConnectionDB();
	}
	private void DriverLoad() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
	}
	private void ConnectionDB() {
		String url="jdbc:mysql://localhost:3306/javaTest";
		String user="javaTest";
		String password="123456";
		try {
			conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			System.out.println("데이터베이스 접속 실패");
		}
	}
}









