package top.yangzhenzhong.bean;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int comm_id;
	private Order order;
	private String comm_comment;
	private Date comm_date;
	private int comm_flag;
	private int comm_pointer;
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getComm_comment() {
		return comm_comment;
	}
	public void setComm_comment(String comm_comment) {
		this.comm_comment = comm_comment;
	}
	public Date getComm_date() {
		return comm_date;
	}
	public void setComm_date(Date comm_date) {
		this.comm_date = comm_date;
	}
	public int getComm_flag() {
		return comm_flag;
	}
	public void setComm_flag(int comm_flag) {
		this.comm_flag = comm_flag;
	}
	public int getComm_pointer() {
		return comm_pointer;
	}
	public void setComm_pointer(int comm_pointer) {
		this.comm_pointer = comm_pointer;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int comm_id, Order order, String comm_comment, Date comm_date, int comm_flag, int comm_pointer) {
		super();
		this.comm_id = comm_id;
		this.order = order;
		this.comm_comment = comm_comment;
		this.comm_date = comm_date;
		this.comm_flag = comm_flag;
		this.comm_pointer = comm_pointer;
	}
	@Override
	public String toString() {
		return "Comment [comm_id=" + comm_id + ", order=" + order + ", comm_comment=" + comm_comment + ", comm_date="
				+ comm_date + ", comm_flag=" + comm_flag + ", comm_pointer=" + comm_pointer + "]";
	}
	
}
