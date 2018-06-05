package top.yangzhenzhong.biz.impl;

import java.util.List;

import top.yangzhenzhong.bean.Local;
import top.yangzhenzhong.biz.LocalBiz;

public class LocalBizImpl implements LocalBiz {

	@Override
	public List<Local> getAll(int u_id) {
		List<Local> locList = locDao.getAllByUid(u_id);
		return locList;
	}

	@Override
	public List<Local> add(Local local) {
		locDao.addLoc(local);
		List<Local> locList = locDao.getAllByUid(local.getU_id());
		return locList;
	}

}
