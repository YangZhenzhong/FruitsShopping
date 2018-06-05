package top.yangzhenzhong.bean;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_id;//用户id
	private String u_phone;//手机号
	private String u_pwd;//密码
	private String u_picture;//头像地址
	private int u_lv;//会员级别
	private String u_qq;//qq号
	private String u_name;//昵称
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_picture() {
		return u_picture;
	}
	public void setU_picture(String u_picture) {
		this.u_picture = u_picture;
	}
	public int getU_lv() {
		return u_lv;
	}
	public void setU_lv(int u_lv) {
		this.u_lv = u_lv;
	}
	public String getU_qq() {
		return u_qq;
	}
	public void setU_qq(String u_qq) {
		this.u_qq = u_qq;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_phone=" + u_phone + ", u_pwd=" + u_pwd + ", u_picture=" + u_picture
				+ ", u_lv=" + u_lv + ", u_qq=" + u_qq + ", u_name=" + u_name + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int u_id, String u_phone, String u_pwd, String u_picture, int u_lv, String u_qq, String u_name) {
		super();
		this.u_id = u_id;
		this.u_phone = u_phone;
		this.u_pwd = u_pwd;
		this.u_picture = u_picture;
		this.u_lv = u_lv;
		this.u_qq = u_qq;
		this.u_name = u_name;
	}
	
	
}
