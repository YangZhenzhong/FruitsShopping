package top.yangzhenzhong.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int o_id;
	private State state;
	private Local loc;
	private int wl_id;
	private String o_zhifufangshi;
	private Date o_date;
	private int u_id;
	//后面加的
	private int total;
	/**
	 * detail
	 * @return
	 */
	private List<QingDan> detailL;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<QingDan> getDetailL() {
		return detailL;
	}
	public void setDetailL(List<QingDan> detailL) {
		this.detailL = detailL;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Local getLoc() {
		return loc;
	}
	public void setLoc(Local loc) {
		this.loc = loc;
	}
	public int getWl_id() {
		return wl_id;
	}
	public void setWl_id(int wl_id) {
		this.wl_id = wl_id;
	}
	public String getO_zhifufangshi() {
		return o_zhifufangshi;
	}
	public void setO_zhifufangshi(String o_zhifufangshi) {
		this.o_zhifufangshi = o_zhifufangshi;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int o_id, State state, Local loc, int wl_id, String o_zhifufangshi, Date o_date, int u_id) {
		super();
		this.o_id = o_id;
		this.state = state;
		this.loc = loc;
		this.wl_id = wl_id;
		this.o_zhifufangshi = o_zhifufangshi;
		this.o_date = o_date;
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", state=" + state + ", loc=" + loc + ", wl_id=" + wl_id + ", o_zhifufangshi="
				+ o_zhifufangshi + ", o_date=" + o_date + ", u_id=" + u_id + ", total=" + total + ", detailL=" + detailL
				+ "]";
	}
	public Order(int o_id, State state, Local loc, int wl_id, String o_zhifufangshi, Date o_date, int u_id, int total,
			List<QingDan> detailL) {
		super();
		this.o_id = o_id;
		this.state = state;
		this.loc = loc;
		this.wl_id = wl_id;
		this.o_zhifufangshi = o_zhifufangshi;
		this.o_date = o_date;
		this.u_id = u_id;
		this.total = total;
		this.detailL = detailL;
	}
	
	
}
