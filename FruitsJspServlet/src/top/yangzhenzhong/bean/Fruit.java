package top.yangzhenzhong.bean;

import java.io.Serializable;

public class Fruit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int f_id;
	private Sort s;
	private String f_guige;
	private String f_tuwen;
	private int f_kucun;
	private int f_price;
	private int f_yuanjia;
	private String f_pic;
	private String f_name;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_pic() {
		return f_pic;
	}
	public void setF_pic(String f_pic) {
		this.f_pic = f_pic;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public Sort getS() {
		return s;
	}
	public void setS(Sort s) {
		this.s = s;
	}
	public String getF_guige() {
		return f_guige;
	}
	public void setF_guige(String f_guige) {
		this.f_guige = f_guige;
	}
	public String getF_tuwen() {
		return f_tuwen;
	}
	public void setF_tuwen(String f_tuwen) {
		this.f_tuwen = f_tuwen;
	}
	public int getF_kucun() {
		return f_kucun;
	}
	public void setF_kucun(int f_kucun) {
		this.f_kucun = f_kucun;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public int getF_yuanjia() {
		return f_yuanjia;
	}
	public void setF_yuanjia(int f_yuanjia) {
		this.f_yuanjia = f_yuanjia;
	}
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fruit(Sort s, String f_guige, String f_tuwen, int f_kucun, int f_price, int f_yuanjia, String f_pic,
			String f_name) {
		super();
		this.s = s;
		this.f_guige = f_guige;
		this.f_tuwen = f_tuwen;
		this.f_kucun = f_kucun;
		this.f_price = f_price;
		this.f_yuanjia = f_yuanjia;
		this.f_pic = f_pic;
		this.f_name = f_name;
	}
	@Override
	public String toString() {
		return "Fruit [f_id=" + f_id + ", s=" + s + ", f_guige=" + f_guige + ", f_tuwen=" + f_tuwen + ", f_kucun="
				+ f_kucun + ", f_price=" + f_price + ", f_yuanjia=" + f_yuanjia + ", f_pic=" + f_pic + ", f_name="
				+ f_name + "]";
	}
	public Fruit(int f_id, Sort s, String f_guige, String f_tuwen, int f_kucun, int f_price, int f_yuanjia,
			String f_pic, String f_name) {
		super();
		this.f_id = f_id;
		this.s = s;
		this.f_guige = f_guige;
		this.f_tuwen = f_tuwen;
		this.f_kucun = f_kucun;
		this.f_price = f_price;
		this.f_yuanjia = f_yuanjia;
		this.f_pic = f_pic;
		this.f_name = f_name;
	}

	

		
}
