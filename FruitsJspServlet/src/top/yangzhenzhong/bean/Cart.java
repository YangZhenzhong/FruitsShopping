package top.yangzhenzhong.bean;

import java.io.Serializable;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int c_id;
	private Fruit fruit;
	private	int u_id;
	private int c_num;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", fruit=" + fruit + ", u_id=" + u_id + ", c_num=" + c_num + "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int c_id, Fruit fruit, int u_id, int c_num) {
		super();
		this.c_id = c_id;
		this.fruit = fruit;
		this.u_id = u_id;
		this.c_num = c_num;
	}
	
}
