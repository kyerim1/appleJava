package DTO;

import java.util.Date;

public class LoginHistory {
	private int id;
	private Date login_date;
	private String ip;
	
	public LoginHistory(int id, String ip, Date date) {
		this.id=id;
		this.ip=ip;
		this.login_date=date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
