package entity;

public class member {
	private int num;
	private String id;
	private String pw;
	private String email;
	private String tel;
	
	public member() {}
	public member(int num, String id, String pw, String email, String tel) {
		this.num=num;
		this.id=id;
		this.pw=pw;
		this.email=email;
		this.tel=tel;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
