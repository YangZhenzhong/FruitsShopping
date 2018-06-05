package top.yangzhenzhong.biz.impl;

import java.util.List;

import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.biz.SortBiz;
import top.yangzhenzhong.dao.SortDao;
import util.DaoFactory;

public class SortBizImpl implements SortBiz {
	SortDao sDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.SortDaoImpl",SortDao.class);
	@Override
	public List<Sort> getAll() {
		List<Sort> list = sDao.getAll();
		return list;
	}

	@Override
	public boolean add(Sort s) {
		boolean flag = false;
		
		int row = sDao.add(s);
		if(row>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete(int s_id) {
	boolean flag = false;
		
		int row = sDao.deleteById(s_id);
		if(row>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean update(Sort s) {
	boolean flag = false;
		
		int row = sDao.update(s);
		if(row>0){
			flag = true;
		}
		return flag;
	}
}
