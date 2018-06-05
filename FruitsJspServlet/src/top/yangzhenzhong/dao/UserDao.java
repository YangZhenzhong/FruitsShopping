package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.User;

public interface  UserDao {
	/**
	 * 查看所有用户
	 * @return
	 */
	public List<User> getAll();
	/**
	 * 查找用户
	 */
	public User getByPhone(String u_phone);
	/**
	 * 注册用户
	 */
	public int addUser(User u);
}
