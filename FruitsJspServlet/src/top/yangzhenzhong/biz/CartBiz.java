package top.yangzhenzhong.biz;

import java.util.List;

import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.dao.CartDao;
import util.DaoFactory;

public interface CartBiz {
	CartDao cDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.CartDaoImpl",CartDao.class);
	/**
	 * 显示购物车
	 * @param u_id
	 * @return
	 */
	public	List<Cart> showCart(int u_id);
	/**
	 * 减少购物车商品数量
	 * @param c_id
	 */
	public void reduceCartNum(int c_id);
	/**
	 * 增加商品数量
	 * @param c_id
	 */
	public void plusCartNum(int c_id);
	/**
	 * 清空购物车
	 * @param u_id
	 */
	public void deleteAll(int u_id);
	/**
	 * 添加到购物车
	 * @param u_id
	 */
	public void addCart(Cart cart);
}
