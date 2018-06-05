package top.yangzhenzhong.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.dao.SortDao;
import util.JDBCUtil;

public class SortDaoImpl implements SortDao {

	@Override
	public List<Sort> getAll() {
		List<Sort> list = new ArrayList<Sort>();

		String sql = "select s_id,s_name from sort";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while (rs.next()) {
				Sort s = new Sort();
				s.setS_id(rs.getInt("s_id"));
				s.setS_name(rs.getString("s_name"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}

	

		return list;
	}

	@Override
	public int update(Sort s) {
		String sql = "update sort set s_name='" + s.getS_name() + "' where s_id=" + s.getS_id();
		int row = JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
		return row;
	}

	@Override
	public int deleteById(int s_id) {
		String sql = "delete from sort where s_id="+s_id;
		int row = JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
		return row;
	}

	@Override
	public int add(Sort s) {
		String sql = "insert into sort(s_name) values('"+s.getS_name()+"')";
		int row = JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
		return row;
	}
	/**
	 * 不能关
	 */
	@Override
	public Sort getById(int s_id) {
		Sort s = null;
		String sql = "select * from sort where s_id="+s_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				s=new Sort();
				s.setS_id(rs.getInt("s_id"));
				s.setS_name(rs.getString("s_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
