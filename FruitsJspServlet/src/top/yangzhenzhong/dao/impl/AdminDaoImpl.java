package top.yangzhenzhong.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import top.yangzhenzhong.bean.Admin;
import top.yangzhenzhong.dao.AdminDao;
import util.JDBCUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin getByName(String username) {
		Admin admin  = null;
		String sql = "select id,username,pwd,level from admin where username='"+username+"'";
		try {
			ResultSet rs = JDBCUtil.executeQuery(sql);
			if(rs.next()){
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPwd(rs.getString("pwd"));
				admin.setLevel(rs.getInt("level"));
				admin.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return admin;
	}

}
