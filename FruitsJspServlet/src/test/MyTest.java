package test;

import java.util.List;

import org.junit.Test;

import top.yangzhenzhong.bean.Admin;
import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.dao.AdminDao;
import top.yangzhenzhong.dao.impl.FruitDaoImpl;
import util.DaoFactory;

public class MyTest {
	@Test
	public void testAdminLogin(){
			AdminDao adminDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.AdminDaoImpl", AdminDao.class);
			Admin admin = adminDao.getByName("admin");
			System.out.println(admin);
	}
	@Test
	public void testPage(){
		FruitDaoImpl fDao = new FruitDaoImpl();
		List<Fruit> list = fDao.getPage(1,5);
		for(Fruit f:list){
			System.out.println(f);
		}
	}
}
