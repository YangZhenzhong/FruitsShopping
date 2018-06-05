package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.State;

public interface StateDao {
	/**
	 * 所有订单状态
	 * @return
	 */
	public List<State> getAll();
	/**
	 * 某个订单的状态
	 */
	public State getState(int state_id);
	
}
