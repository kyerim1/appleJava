package DTO;

public class member {
	private int num;
	private String email;
	private String password;
	private String name;
	private String tel;
	
	public member(String email, String password, String name, String tel) {
		this.email=email;
		this.password=password;
		this.name=name;
		this.tel=tel;
	}
	public member(int num, String email, String name, String tel) {
		this.num=num;
		this.email=email;
		this.name=name;
		this.tel=tel;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
