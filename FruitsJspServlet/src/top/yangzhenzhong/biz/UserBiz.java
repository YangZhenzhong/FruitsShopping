package top.yangzhenzhong.biz;

import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.dao.UserDao;
import util.DaoFactory;

public interface UserBiz {
	UserDao uDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.UserDaoImpl",UserDao.class);
	/**
	 * 获得所有用户
	 * @return
	 */
	public	List<User> getAll();
	/**
	 * 通过手机号获得用户
	 */
	public Map<String,Object> getByPhone(String u_phone,String u_pwd);
	/**
	 * 注册用户
	 */
	public int registU(User u);
}
