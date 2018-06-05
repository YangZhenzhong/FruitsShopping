package top.yangzhenzhong.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.dao.UserDao;
import util.JDBCUtil;
public class UserDaoImpl implements  UserDao{

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				User u = new User();
				u.setU_id(rs.getInt("u_id"));
				u.setU_lv(rs.getInt("u_lv"));
				u.setU_name(rs.getString("u_name"));
				u.setU_phone(rs.getString("u_phone"));
				u.setU_picture(rs.getString("u_picture"));
				u.setU_pwd(rs.getString("u_pwd"));
				u.setU_qq(rs.getString("u_qq"));
				list.add(u);
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
	public User getByPhone(String u_phone) {
		User u = null;
		String sql = "select * from user where u_phone='"+u_phone+"'";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				u = new User();
				u.setU_id(rs.getInt("u_id"));
				u.setU_lv(rs.getInt("u_lv"));
				u.setU_name(rs.getString("u_name"));
				u.setU_phone(rs.getString("u_phone"));
				u.setU_picture(rs.getString("u_picture"));
				u.setU_pwd(rs.getString("u_pwd"));
				u.setU_qq(rs.getString("u_qq"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}JDBCUtil.myclose();
		return u;
	}

	@Override
	public int addUser(User u) {	
		int i = 0;
		String sql = "INSERT INTO user(u_phone,u_pwd,u_name) VALUES ('"+u.getU_phone()+"', '"+u.getU_pwd()+"','ZhongGeGe')";
		 i= JDBCUtil.executeUpdate(sql);
		return i;
	}

}
