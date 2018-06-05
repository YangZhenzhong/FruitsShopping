package top.yangzhenzhong.biz;

import java.util.List;

import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.dao.FruitDao;
import util.DaoFactory;
import util.SelectUtil;

public interface FruitBiz {
	FruitDao fDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.FruitDaoImpl",FruitDao.class);
	/**
	 * 获取某一页
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Fruit> getPage(int page,int rows);
	/**
	 * 获得总商品数
	 * @return
	 */
	public int getNum();
	/**
	 * 添加商品
	 */
	public void add(Fruit f);
	/**
	 * 获得某个商品
	 */
	public Fruit getById(int f_id);
	/**
	 * 删除商品
	 */
	public void delete(int f_id);
	/**
	 * 更新商品
	 * @param f
	 */
	public void update(Fruit f);
	/**
	 *条件查询获得结果集
	 * @param sUtil
	 * @return
	 */
	public List<Fruit> getByFruit(SelectUtil sUtil);
	/**
	 * 查询所有商品
	 * @param sUtil
	 * @return
	 */
	public List<Fruit> getAll(SelectUtil sUtil);
}
