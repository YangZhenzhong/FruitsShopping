package top.yangzhenzhong.biz.impl;

import java.util.List;

import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.biz.CartBiz;

public class CartBizImpl implements CartBiz {

	@Override
	public List<Cart> showCart(int u_id) {
		List<Cart> cList = cDao.getCart(u_id);
		
		return cList;
	}

	@Override
	public void reduceCartNum(int c_id) {
		Cart c = cDao.getByCid(c_id);
		if(c.getC_num()>1){
			cDao.updateCartNumReduce(c_id);
		}else{
			cDao.delete(c_id);
		}
		
	}

	@Override
	public void plusCartNum(int c_id) {
		cDao.updateCartNumPlus(c_id);
		
	}

	@Override
	public void deleteAll(int u_id) {
		cDao.deleteAll(u_id);
	}

	@Override
	public void addCart(Cart cart) {
		Cart c = cDao.isExist(cart.getU_id(), cart.getFruit().getF_id());
		if(c==null){
			cDao.addCart(cart);
		}else{
			cDao.updateCartNumPlus(c.getC_id());
		}
	}

}
