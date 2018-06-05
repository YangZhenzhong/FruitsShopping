package top.yangzhenzhong.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.dao.LocDao;
import top.yangzhenzhong.dao.OrderDao;
import top.yangzhenzhong.dao.QingDanDao;
import top.yangzhenzhong.dao.StateDao;
import util.DaoFactory;
import util.JDBCUtil;

public class OrderDaoImpl implements OrderDao {
	LocDao lDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.LocDaoImpl", LocDao.class);
	StateDao stateDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.StateDaoImpl", StateDao.class);
	QingDanDao qdDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.QingDanDaoImpl", QingDanDao.class);
	@Override
	public List<Order> getAll() {
		List<Order> list=new ArrayList<Order>();
		String sql = "select * from orders order by o_id DESC";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Order o = new Order();
				o.setLoc(lDao.getByLocid(rs.getInt("loc_id")));
				o.setO_date(rs.getDate("o_date"));
				o.setO_id(rs.getInt("o_id"));
				o.setO_zhifufangshi(rs.getString("o_zhifufangshi"));
				o.setState(stateDao.getState(rs.getInt("state_id")));
				o.setU_id(rs.getInt("u_id"));
				o.setWl_id(rs.getInt("wl_id"));
				o.setDetailL(qdDao.selectQingDanByOid(o.getO_id()));
				o.setTotal(rs.getInt("total"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Order getByOid(int o_id) {
		Order o=null;
		String sql = "select * from orders where o_id="+o_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				o = new Order();
				o.setLoc(lDao.getByLocid(rs.getInt("loc_id")));
				o.setO_date(rs.getDate("o_date"));
				o.setO_id(rs.getInt("o_id"));
				o.setO_zhifufangshi(rs.getString("o_zhifufangshi"));
				o.setState(stateDao.getState(rs.getInt("state_id")));
				o.setU_id(rs.getInt("u_id"));
				o.setWl_id(rs.getInt("wl_id"));
				o.setDetailL(qdDao.selectQingDanByOid(o.getO_id()));
				o.setTotal(rs.getInt("total"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	@Override
	public List<Order> getUserOrder(int u_id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from orders where u_id="+u_id+" order by o_id DESC";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Order o = new Order();
				o.setLoc(lDao.getByLocid(rs.getInt("loc_id")));
				o.setO_date(rs.getDate("o_date"));
				o.setO_id(rs.getInt("o_id"));
				o.setO_zhifufangshi(rs.getString("o_zhifufangshi"));
				o.setState(stateDao.getState(rs.getInt("state_id")));
				o.setU_id(rs.getInt("u_id"));
				o.setWl_id(rs.getInt("wl_id"));
				o.setDetailL(qdDao.selectQingDanByOid(o.getO_id()));
				o.setTotal(rs.getInt("total"));
				list.add(o);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return list;
	}
	@Override
	public void addOrder(Order o) throws SQLException {
		String sql = "insert into orders(state_id,loc_id,o_date,u_id,total) values("+o.getState().getState_id()+","+o.getLoc().getLoc_id()+",SYSDATE(),"+o.getU_id()+","+o.getTotal()+")";
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		pstm.executeUpdate();
	}
	@Override
	public int getNewOid(int u_id) throws SQLException {
		int o_id=-1;
		String sql = "select max(o_id) myid from orders where u_id="+u_id;
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()){
			o_id =rs.getInt("myid");
		}
		return o_id;
	}
	@Override
	public void updateState(int o_id, int state_id) throws SQLException {
		String sql = "update orders set state_id="+state_id+" where o_id="+o_id;
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		pstm.executeUpdate();
	}

}
