package top.yangzhenzhong.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.dao.CartDao;
import top.yangzhenzhong.dao.CommentDao;
import top.yangzhenzhong.dao.FruitDao;
import top.yangzhenzhong.dao.OrderDao;
import top.yangzhenzhong.dao.QingDanDao;
import util.DaoFactory;

public interface OrderBiz {
	OrderDao oDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.OrderDaoImpl",OrderDao.class);
	CartDao cDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.CartDaoImpl", CartDao.class);
	QingDanDao qdDao =  DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.QingDanDaoImpl", QingDanDao.class);
	FruitDao fDao =  DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.FruitDaoImpl", FruitDao.class);
	CommentDao commDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.CommentDaoImpl",CommentDao.class);
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Order> getAll();
	/**
	 * 获得用户的订单
	 */
	public Map<Integer,Object> getUserOrder(int u_id);
	/**
	 * 添加订单
	 * @param o
	 * @param cidList
	 * @return
	 * @throws SQLException 
	 */
	public boolean addOrder(Order o,List<Integer> cidList) throws SQLException;
	/**
	 * 查看订单详情
	 */
	public Order getDetail(int o_id);
	/**
	 * 取消订单
	 * @param o_id
	 * @param state_id
	 * @throws SQLException 
	 */
	public void quxiao(int o_id, int state_id) throws SQLException;
	/**
	 * 支付成功，插入评论和修改订单状态
	 */
	public void successPay(int o_id,int state_id,Comment comm);
	
}
