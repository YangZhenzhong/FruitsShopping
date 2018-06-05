package top.yangzhenzhong.dao;

import java.sql.SQLException;
import java.util.List;

import top.yangzhenzhong.bean.Fruit;
import util.SelectUtil;

public interface FruitDao {
	/**
	 * 显示某一页的数据
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Fruit> getPage(int page,int rows);
	/**
	 * 通过类别查询商品
	 * @param id
	 * @return
	 */
	public List<Fruit> getBySortId(int s_id);

	/**
	 *类比
	 * @param s_id
	 * @param col
	 * @param asc
	 * @param key
	 * @return
	 */
	public List<Fruit> getByFruit(SelectUtil sUtil);
	/**
	 * 全部商品,条件
	 */
	public List<Fruit> getAll(SelectUtil sUtil);
	/**
	 * 添加水果
	 * @param f
	 * @return
	 */
	public int  addFruit(Fruit f);
	/**
	 * 删除水果
	 */
	public int deleteFruit(int f_id);
	/**
	 *admin 更新水果
	 */
	public void update(Fruit f);
	/**
	 * 购买，或添库存
	 * @param f_id
	 * @param num
	 * @param opt
	 */
	public void buyOrAdd(int f_id,int num,String opt);
	/**
	 * 获得商品总数
	 * @return
	 */
	public int getNum();
	
	/**
	 * 获得某个商品信息
	 */
	public Fruit getById(int f_id);
	/**
	 * 减少商品数量
	 * @param f_id
	 * @param c_num
	 * @throws SQLException 
	 */
	public void updateNum(int f_id, int c_num) throws SQLException;
}
