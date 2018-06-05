package top.yangzhenzhong.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.bean.QingDan;
import top.yangzhenzhong.biz.OrderBiz;
import util.JDBCUtil;

public class OrderBizImpl implements OrderBiz {
	
	@Override
	public List<Order> getAll() {
		List<Order> oList = oDao.getAll();
		return oList;
	}

	@Override
	public Map<Integer, Object> getUserOrder(int u_id) {
		Map<Integer, Object> map = new HashMap<Integer,Object>();
		List<Order> listNo = new ArrayList<Order>();
		List<Order> listS = new ArrayList<Order>();
		List<Order> listQ = new ArrayList<Order>();
		List<Order> oList = oDao.getUserOrder(u_id);
		for(Order o:oList){
			switch (o.getState().getState_id()) {
			case 1:
				listNo.add(o);
				break;
			case 2:
				listS.add(o);
				break;
			case 3:
				listQ.add(o);
				break;
			default:
				break;
			}
		}
		map.put(1,listNo);
		map.put(2,listS);
		map.put(3,listQ);
		return map;
	}

	@Override
	public boolean addOrder(Order o, List<Integer> cidList) throws SQLException {
			Connection conn = JDBCUtil.getConn();
			try {
				conn.setAutoCommit(false);
				oDao.addOrder(o);
				int o_id = oDao.getNewOid(o.getU_id());
				for(int c_id:cidList){
					QingDan qd = new QingDan();
					Cart c = cDao.getByCid(c_id);
					qd.setFruit(c.getFruit());
					qd.setO_id(o_id);
					qd.setQd_num(c.getC_num());
					qd.setQd_price(c.getFruit().getF_price());
					//添加到清单
					qdDao.addQingDan(qd);
					fDao.updateNum(c.getFruit().getF_id(),c.getC_num());
					cDao.delete(c_id);
				}
				conn.commit();
				conn.setAutoCommit(true);
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				JDBCUtil.rollback();
			}
		return false;
	}
	/**
	 * 查看订单详情
	 */
	@Override
	public Order getDetail(int o_id) {
		Order order = oDao.getByOid(o_id);
		return order;
	}

	@Override
	public void quxiao(int o_id, int state_id) throws SQLException {
		//开始事物
		Connection conn = JDBCUtil.getConn();
		conn.setAutoCommit(false);
		//更改订单状态
		try{
			oDao.updateState(o_id, state_id);
			List<QingDan> qdList = qdDao.selectQingDanByOid(o_id);
			//更改商品数量
			for(QingDan qd:qdList){
				fDao.updateNum(qd.getFruit().getF_id(), -qd.getQd_num());
			}
			conn.commit();
			conn.setAutoCommit(true);
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			JDBCUtil.rollback();
		}
	}

	@Override
	public void successPay(int o_id,int state_id,Comment comm) {
		try {
			oDao.updateState(o_id, state_id);
			commDao.add(comm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
