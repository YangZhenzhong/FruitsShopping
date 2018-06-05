package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.Local;

public interface LocDao {
	/**
	 * 获得某个用户的所有地址
	 * @param u_id
	 * @return
	 */
	public List<Local> getAllByUid(int u_id);
	/**
	 * 得到地址信息
	 * @param u_id
	 * @return
	 */
	public Local getByLocid(int loc_id);
	/**
	 * 添加地址信息
	 * @param loc
	 */
	public void addLoc(Local loc);
}
