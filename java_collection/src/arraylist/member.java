package arraylist;

public class member {
	private String name;
	private String email;
	private String gender;
	private int phone;
	
	public member() {}
	public member(String name, String email, String gender, int phone) {
		this.name=name;
		this.email=email;
		this.gender=gender;
		this.phone=phone;
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+" 이메일 : "+email+" 연락처 : "+myPhone()+" 성별 : "+gender;
	}
	
	public String myPhone() {
		String tmp = Integer.toString(phone);
		String p1 = tmp.substring(0,2);
		String p2 = tmp.substring(2,6);
		String p3 = tmp.substring(6);
		return "0"+p1+"-"+p2+"-"+p3;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
