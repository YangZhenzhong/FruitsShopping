package top.yangzhenzhong.bean;

import java.io.Serializable;

public class QingDan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int qd_id;
	private int o_id;
	private Fruit fruit;
	private int qd_num;
	private int qd_price;
	public int getQd_id() {
		return qd_id;
	}
	public void setQd_id(int qd_id) {
		this.qd_id = qd_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public int getQd_num() {
		return qd_num;
	}
	public void setQd_num(int qd_num) {
		this.qd_num = qd_num;
	}
	public int getQd_price() {
		return qd_price;
	}
	public void setQd_price(int qd_price) {
		this.qd_price = qd_price;
	}
	public QingDan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	@Override
	public String toString() {
		return "QingDan [qd_id=" + qd_id + ", o_id=" + o_id + ", fruit=" + fruit + ", qd_num=" + qd_num + ", qd_price="
				+ qd_price + "]";
	}
	public QingDan(int o_id, Fruit fruit, int qd_num, int qd_price) {
		super();
		this.o_id = o_id;
		this.fruit = fruit;
		this.qd_num = qd_num;
		this.qd_price = qd_price;
	}
	public QingDan(int qd_id, int o_id, Fruit fruit, int qd_num, int qd_price) {
		super();
		this.qd_id = qd_id;
		this.o_id = o_id;
		this.fruit = fruit;
		this.qd_num = qd_num;
		this.qd_price = qd_price;
	}
	

	
}
