package top.yangzhenzhong.bean;

import java.io.Serializable;

public class Local implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int loc_id;
	private String loc_name;
	private String local;
	private String phone;
	private int u_id;
	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Local(int loc_id, String loc_name, String local, String phone, int u_id) {
		super();
		this.loc_id = loc_id;
		this.loc_name = loc_name;
		this.local = local;
		this.phone = phone;
		this.u_id = u_id;
	}
	public int getLoc_id() {
		return loc_id;
	}
	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
}
