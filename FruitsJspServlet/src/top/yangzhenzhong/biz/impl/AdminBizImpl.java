package top.yangzhenzhong.biz.impl;

import java.util.HashMap;
import java.util.Map;

import top.yangzhenzhong.bean.Admin;
import top.yangzhenzhong.biz.AdminBiz;
import top.yangzhenzhong.dao.AdminDao;
import util.DaoFactory;

public class AdminBizImpl implements AdminBiz {
	AdminDao adminDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.AdminDaoImpl", AdminDao.class);
	@Override
	public Map<String,Object> login(String username,String pwd) {
		Map<String,Object> map = new HashMap<String, Object>();
		Admin admin = adminDao.getByName(username);
		if(admin!=null&&pwd.equals(admin.getPwd())){
			map.put("flag","OK");
			map.put("admin",admin);
		}else{
			map.put("flag", "用户名或密码不正确");
		}
		return map;
	}

}
