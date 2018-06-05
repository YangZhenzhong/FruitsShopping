package top.yangzhenzhong.biz.impl;

import java.util.List;

import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.biz.FruitBiz;
import util.SelectUtil;

public class FruitBizImpl implements FruitBiz {

	@Override
	public List<Fruit> getPage(int page, int rows) {
		List<Fruit> list = fDao.getPage(page, rows);
		return list;
	}

	@Override
	public int getNum() {
		int num=0;
		num=fDao.getNum();
		return num;
	}

	@Override
	public void add(Fruit f) {
		fDao.addFruit(f);
	}

	@Override
	public Fruit getById(int f_id) {
		Fruit f = fDao.getById(f_id);
		return f;
	}

	@Override
	public void delete(int f_id) {
		fDao.deleteFruit(f_id);
	}

	@Override
	public void update(Fruit f) {
		fDao.update(f);
	}

	@Override
	public List<Fruit> getByFruit(SelectUtil sUtil) {
		List<Fruit> fList= fDao.getByFruit(sUtil);
		return fList;
	}

	@Override
	public List<Fruit> getAll(SelectUtil sUtil) {
		List<Fruit> fList = fDao.getAll(sUtil);
		return fList;
	}


	

}
