package top.yangzhenzhong.bean;

import java.io.Serializable;

public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String pwd;
	private int level;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int id,String username, String pwd) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
	}
	
	public Admin(int id,String username, String pwd, int level) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.level = level;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", pwd=" + pwd + ", level=" + level + "]";
	}

	
	
}
