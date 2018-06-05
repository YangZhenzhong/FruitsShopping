package top.yangzhenzhong.biz;

import java.util.Map;

public interface AdminBiz {
	/**
	 * 后台登录
	 */
	public Map<String, Object> login(String username, String pwd);
}
