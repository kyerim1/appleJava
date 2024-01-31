package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.board;
import DTO.reply;

public class board_dao extends parent_dao{
	
	public board_dao() {
		createTable();
	}
	
	//답글 삭제 
	public void delete_reply(int id) {
		String sql="delete from reply where id=?";
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("글 삭제 실패");
			e.printStackTrace();
		}
	}
	
	
	
	//특정 게시글의 답글 전체 불러오기
	public List<reply> findReply(int bid){
		List<reply> list = new ArrayList<>();
		
		String sql="select * from reply where board_id=? order by wdate asc";
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, bid);
			rs = pt.executeQuery();
			while( rs.next() ) {
				reply data = new reply(rs.getInt(1), rs.getInt(2), rs.getInt(6),
						rs.getString(3), rs.getString(5) , rs.getTimestamp(4) );
				list.add(data);
			}
			if( !list.isEmpty() ) {
				return list;
			}
			
			
		}catch(SQLException e) {
			System.out.println("답글 불러오기 실패");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	//답글 저장
	public void reply_insert(reply rp) {
		String sql = "insert into reply(board_id, comment, writer, member_id) "
				+ "values(?,?,?,?)";
		
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, rp.getBoard_id());
			pt.setString(2, rp.getComment());
			pt.setString(3, rp.getWriter());
			pt.setInt(4, rp.getMember_id());
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("답글 저장 실패");
			e.printStackTrace();
		}
	}
	
	
	//글 삭제
	public void delete(int id) {
		String sql="delete from board where id=?";
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.executeUpdate();
			
			sql="delete from reply where board_id=?";
			pt=conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("글 삭제 실패");
			e.printStackTrace();
		}
	}
	
	
	// 글 수정 
	public void update(board b) {
		String sql="update board set title=? , lang=? , answer_mail=? ,"
				+ "content=? , wdate=now() where id=?";
				
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, b.getTitle());
			pt.setString(2, b.getLang());
			pt.setString(3, b.getAnswer_mail());
			pt.setString(4, b.getContent());
			pt.setInt(5, b.getId());
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("글 수정 실패");
			e.printStackTrace();
		}
	}
	
	
	
	// 조회수 증가
	public void hitIncrease(int id) {
		String sql="update board set hit=hit+1 where id=?";
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("조회수 증가 실패");
			e.printStackTrace();
		}
	}
	
	
	//상세내용 보기
	public board selectDetail(int id) {
		String sql="select * from board where id=?";
		
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, id);
			rs = pt.executeQuery();
			if( rs.next()) {
				return new board(rs.getInt(1), rs.getInt(7), rs.getInt(9),
						rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5), rs.getString(8), rs.getTimestamp(6));
			}
			
		}catch(SQLException e) {
			System.out.println("글 상세 불러오기 실패");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//board테이블에 저장된 글의 갯수
	public int DbCount() {
		String sql="select count(id) as cnt from board";
		try {
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		}catch(SQLException e) {
			System.out.println("board 총 갯수 구하기 실패");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	// board테이블 불러오기
	public List<board> Allselect( int row ){
		List<board> list = new ArrayList<>();
		
		String sql="select board.* , count(reply.id) as cnt "
				+" from board "
				+" left join reply on board.id=reply.board_id "
				+" group by board.id order by wdate desc limit ? , 10";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, row);
			rs=pt.executeQuery();
			
			while( rs.next() ) {
				board data = new board(rs.getInt(1), rs.getInt(7), rs.getInt(9),
						rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5), rs.getString(8), rs.getTimestamp(6),
						rs.getInt("cnt") );
				list.add(data);
			}
			if( !list.isEmpty() )
				return list;
			
		}catch(SQLException e) {
			System.out.println("board 페이징 불러오기 실패");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	//작성글 데이터베이스 저장
	public void insert(board b) {
		String sql="insert into board(title, writer, answer_mail, "
				+ "lang, content, member_id) values(?,?,?,?,?,?)";
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, b.getTitle() );
			pt.setString(2, b.getWriter() );
			pt.setString(3, b.getAnswer_mail());
			pt.setString(4, b.getLang());
			pt.setString(5, b.getContent());
			pt.setInt(6, b.getMember_id());
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("글 저장 실패");
			e.printStackTrace();
		}
	}
	
	
	
	private void createTable() {
		//테이블 존재 여부 
		String sql="show tables like 'board'";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			if( rs.next() ) { //테이블 존재
				return;
			}
		}catch(SQLException e) {
			System.out.println("board 테이블 확인 실패");
		}
		// 테이블 만들기
		sql="create table board("
				+ "id int auto_increment primary key,"
				+ "title varchar(255) ,"
				+ "writer varchar(255),"
				+ "answer_mail varchar(255),"
				+ "lang varchar(50),"
				+ "wdate datetime default now(),"
				+ "hit int default 0,"
				+ "content text )";
		try {
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			System.out.println("board 테이블 생성 실패");
			e.printStackTrace();
		}
	}
	
//	public void t() {
//		String sql="select * from board";
//		List<board> list= new ArrayList<>();
//		try {
//			st = conn.createStatement();
//			rs=st.executeQuery(sql);
//			System.out.println("aa");
//			while(rs.next()) {
//			list.add(new board(rs.getInt(9), rs.getString(2),rs.getString(3),
//					rs.getString(4),rs.getString(5),rs.getString(8)));
//			}
//		}catch(Exception e) {e.printStackTrace();}
//		
//		sql="insert into board(title, writer, answer_mail, "
//				+ "lang, content, member_id) values(?,?,?,?,?,?)";
//		try {
//			pt=conn.prepareStatement(sql);
//			for(board b : list) {
//				pt.setString(1, b.getTitle() );
//				pt.setString(2, b.getWriter() );
//				pt.setString(3, b.getAnswer_mail());
//				pt.setString(4, b.getLang());
//				pt.setString(5, b.getContent());
//				pt.setInt(6, b.getMember_id());
//				pt.executeUpdate();
//			}
//		}catch(SQLException e) {
//			System.out.println("글 저장 실패");
//			e.printStackTrace();
//		}
//	}
}





