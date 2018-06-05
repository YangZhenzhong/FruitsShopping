package top.yangzhenzhong.biz;

import java.util.List;

import top.yangzhenzhong.bean.Local;
import top.yangzhenzhong.dao.LocDao;
import util.DaoFactory;

public interface LocalBiz {
	LocDao locDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.LocDaoImpl", LocDao.class);
	/**
	 * 查询该用户所有地址
	 * @param u_id
	 * @return
	 */
	public List<Local> getAll(int u_id);
	/**
	 * 添加地址，返回该用户所有新地址
	 * @param local
	 * @return
	 */
	public List<Local> add(Local local);
}
