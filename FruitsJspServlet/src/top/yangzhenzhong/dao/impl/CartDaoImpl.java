package top.yangzhenzhong.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.dao.CartDao;
import top.yangzhenzhong.dao.FruitDao;
import util.DaoFactory;
import util.JDBCUtil;

public class CartDaoImpl implements CartDao {
	FruitDao fDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.FruitDaoImpl",FruitDao.class);
	@Override
	public List<Cart> getCart(int u_id) {
		List<Cart> cList = new ArrayList<Cart>();
		String sql = "select * from cart where u_id="+u_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Cart c = new Cart();
				c.setC_id(rs.getInt("c_id"));
				c.setC_num(rs.getInt("c_num"));
				c.setFruit(fDao.getById(rs.getInt("f_id")));
				c.setU_id(rs.getInt("u_id"));
				cList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return cList;
	}

	@Override
	public Cart isExist(int u_id, int f_id) {
		Cart c = null;
		String sql = "select * from cart where u_id="+u_id+" and f_id="+f_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				c = new Cart();
				c.setC_id(rs.getInt("c_id"));
				c.setC_num(rs.getInt("c_num"));
				c.setFruit(fDao.getById(rs.getInt("f_id")));
				c.setU_id(rs.getInt("u_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	/**
	 * 添加商品到购物车
	 */
	@Override
	public void addCart(Cart cart) {
		String sql  = "insert into cart(f_id,u_id,c_num) values("+cart.getFruit().getF_id()+","+cart.getU_id()+","+cart.getC_num()+")";
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

	@Override
	public void updateCartNumPlus(int c_id) {
		String sql = "update cart set c_num=c_num+1 where c_id="+c_id;
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

	@Override
	public void updateCartNumReduce(int c_id) {
		String sql = "update cart set c_num=c_num-1 where c_id="+c_id;
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

	@Override
	public Cart getByCid(int c_id) {
		Cart c = null;
		String sql = "select * from cart where c_id="+c_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				c = new Cart();
				c.setC_id(rs.getInt("c_id"));
				c.setC_num(rs.getInt("c_num"));
				c.setFruit(fDao.getById(rs.getInt("f_id")));
				c.setU_id(rs.getInt("u_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(int c_id) {
		String sql = "delete from cart where c_id="+c_id;
		JDBCUtil.executeUpdate(sql);
	}

	@Override
	public void deleteAll(int u_id) {
		String sql = "delete from cart where u_id="+u_id;
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

}
