package top.yangzhenzhong.dao;

import java.sql.SQLException;
import java.util.List;

import top.yangzhenzhong.bean.Order;

public interface OrderDao {
	/**
	 * 获得所有订单
	 * @return
	 */
	public List<Order> getAll();
	/**
	 * 获得某一个订单
	 */
	public Order getByOid(int o_id);
	/**
	 * 获得某个用户的所有订单
	 * @param u_id
	 * @return
	 */
	public List<Order> getUserOrder(int u_id);
	/**
	 * 添加订单
	 * @param o
	 */
	public void addOrder(Order o) throws SQLException ;
	/**
	 * 获得刚插入的订单号
	 * @param u_id
	 * @return
	 * @throws SQLException 
	 */
	public int getNewOid(int u_id) throws SQLException; 
	/**
	 * 修改订单状态
	 * @throws SQLException 
	 */
	public void updateState(int o_id,int state_id) throws SQLException;
}
