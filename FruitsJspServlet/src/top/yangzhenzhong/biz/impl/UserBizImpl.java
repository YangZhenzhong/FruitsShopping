package top.yangzhenzhong.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.UserBiz;

public class UserBizImpl implements UserBiz {

	@Override
	public List<User> getAll() {
		List<User> list = uDao.getAll();
		return list;
	}

	@Override
	public Map<String, Object> getByPhone(String u_phone, String u_pwd) {
		Map<String,Object> map = new HashMap<String, Object>();
		User u = uDao.getByPhone(u_phone);
		if(u!=null&&u.getU_pwd().equals(u_pwd)){
			map.put("flag","OK");
			map.put("user", u);
		}else{
			map.put("flag","账号或密码不正确");
		}
		return map;
	}

	@Override
	public int registU(User u) {
		int i = uDao.addUser(u);
		return i;
	}


}
