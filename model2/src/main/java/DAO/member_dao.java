package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.member;

public class member_dao {
	private Connection conn=null; //접속
	private Statement st=null; // sql질의문
	private PreparedStatement pt =null; //Sql질의문
	private ResultSet rs=null; // 결과 
	
	public member_dao() {
		DriverLoad();
		ConnectionDB();
	}
	
	
	// 로그인 처리 메서드
	public member findByemailpw(String email, String pw) {
		
		String sql="select * from member where email=? and pw=?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, email);
			pt.setString(2, pw);
			rs = pt.executeQuery();
			if( rs.next() ) { // 참일경우 로그인 성공
				return new member(rs.getInt("id"), email,
						rs.getString("name"), rs.getString("tel"));
			}
			
		}catch(SQLException e) {
			System.out.println("로그인 인증  데이터베이스 조회 실패");
			e.printStackTrace();
		}
		
		return null; // 로그인 실패(이메일또는 비번 틀림)
	}
	
	
	public String[] findAllEmail() {
		
		List<String> list = new ArrayList<>();
		String sql ="select email from member";
		try {
			st = conn.createStatement(); // Statement 객체 생성
			rs = st.executeQuery(sql);// Statement를 이용해서 sql문 보내고 결과 받기
			while( rs.next()) { //resultset에 저장된 데이터 만큼 반복
				list.add(rs.getString("email"));
			}
			if( list.isEmpty() ) return null;
			else return list.toArray(new String[list.size()]);
			
			
		}catch(SQLException e) {
			System.out.println("이메일 조회하기 실패");
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(member data) {
		
		String sql="insert into member(email, pw, name, tel) values(?,?,?,?)";
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, data.getEmail() );
			pt.setString(2,  data.getPassword());
			pt.setString(3, data.getName() );
			pt.setString(4, data.getTel() );
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("회원가입 데이터베이스 저장 실패");
			e.printStackTrace();
		}
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








