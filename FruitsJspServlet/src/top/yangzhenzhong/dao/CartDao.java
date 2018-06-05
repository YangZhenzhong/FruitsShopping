package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.Cart;

public interface CartDao {
	/**
	 * 获得用户购物车
	 * @param u_id
	 * @return
	 */
	public List<Cart> getCart(int u_id);
	/**
	 * 判断是否存在此商品
	 * @param u_id
	 * @param f_id
	 * @return
	 */
	public Cart isExist(int u_id,int f_id);
	/**
	 * 添加商品到购物车
	 * @param cart
	 */
	public void addCart(Cart cart);
	/**
	 * 商品数量加一
	 * update cart set c_num=c_num+1 where c_id=1;
	 * @param c_id
	 */
	public void updateCartNumPlus(int c_id);
	/**
	 * 商品数量减一
	 * update cart set c_num=c_num-1 where c_id=1;
	 */
	public void updateCartNumReduce(int c_id);
	/**
	 * 查某一购物车
	 */
	public Cart getByCid(int c_id);
	/**
	 * 删除某商品
	 * @param c_id
	 */
	public void delete(int c_id);
	/**
	 * 清空购物车
	 * @param u_id
	 */
	public void deleteAll(int u_id);
	
}
