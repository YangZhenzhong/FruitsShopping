package top.yangzhenzhong.dao;

import top.yangzhenzhong.bean.Admin;
/**
 * 管理员登录
 * @author yzz
 *
 */
public interface AdminDao {
	public Admin getByName(String username);
}
