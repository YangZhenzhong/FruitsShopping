package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.Sort;

public interface SortDao {
	/**
	 * 获得所有类别
	 * @return
	 */
	public List<Sort> getAll();
	/**
	 * 修改商品类别
	 * @param s
	 */
	public int update(Sort s);
	/**
	 * 删除商品类别
	 * @param s_id
	 */
	public int deleteById(int s_id);
	/**
	 * 添加商品
	 * @param s
	 */
	public int add(Sort s);
	/**
	 * 获取类别
	 * @param s_id
	 * @return
	 */
	public Sort getById(int s_id);
}
