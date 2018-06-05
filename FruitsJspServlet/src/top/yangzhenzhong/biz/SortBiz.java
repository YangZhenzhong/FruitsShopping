package top.yangzhenzhong.biz;

import java.util.List;

import top.yangzhenzhong.bean.Sort;

public interface SortBiz {
	/**
	 * 获得所有水果类别
	 * @return
	 */
	public List<Sort> getAll();
	/**
	 * 添加类别
	 * @param s
	 * @return
	 */
	public boolean add(Sort s);
	/**
	 * 删除类别
	 * @param s_id
	 * @return
	 */
	public boolean delete(int s_id);
	/**
	 * 修改类别
	 * @param s
	 * @return
	 */
	public boolean update(Sort s);
	
}
