package top.yangzhenzhong.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Local;
import top.yangzhenzhong.dao.LocDao;
import util.JDBCUtil;

public class LocDaoImpl implements LocDao {

	@Override
	public List<Local> getAllByUid(int u_id) {
		List<Local> list = new ArrayList<Local>();
		String sql = "select * from local where u_id="+u_id+" order by loc_id DESC";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Local l = new Local();
				l.setLoc_id(rs.getInt("loc_id"));
				l.setLoc_name(rs.getString("loc_name"));
				l.setLocal(rs.getString("local"));
				l.setPhone(rs.getString("loc_phone"));
				l.setU_id(rs.getInt("u_id"));
				list.add(l);
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
	public Local getByLocid(int loc_id) {
		Local l = null;
		String sql ="select * from local where loc_id="+loc_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				l = new Local();
				l.setLoc_id(rs.getInt("loc_id"));
				l.setLoc_name(rs.getString("loc_name"));
				l.setLocal(rs.getString("local"));
				l.setPhone(rs.getString("loc_phone"));
				l.setU_id(rs.getInt("u_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void addLoc(Local loc) {
		String sql = "insert into local(loc_name,local,loc_phone,u_id) values('"+loc.getLoc_name()+"','"+loc.getLocal()+"','"+loc.getPhone()+"',"+loc.getU_id()+")";
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

}
