package DTO;

import java.util.Date;

public class reply {
	private int id;
	private int board_id;
	private int member_id;
	private String comment;
	private String writer;
	private Date wdate;
	
	
	public reply(int bid, int mid, String comment, String writer) {
		this.board_id=bid;
		this.member_id=mid;
		this.comment=comment;
		this.writer=writer;
	}
	public reply(int id, int bid, int mid, String comment, String writer, Date wdate) {
		this(bid,mid,comment,writer);
		this.id=id;
		this.wdate=wdate;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
}
