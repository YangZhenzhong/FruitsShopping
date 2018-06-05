package top.yangzhenzhong.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.biz.CommentBiz;

public class CommentBizImpl implements CommentBiz {

	@Override
	public List<Comment> getAll() {
		List<Comment> list = commDao.getAll();
		return list;
	}

	@Override
	public void delete(int comm_id) {
		commDao.delete(comm_id);
	}

	@Override
	public void add(Comment comm) {
		commDao.add(comm);
	}
	/**
	 * 查询该用户的
	 */
	@Override
	public Map<Integer, Object> getUComment(int u_id) {
		Map<Integer,Object> commMap = new HashMap<Integer,Object>();
		List<Order> olist = oDao.getUserOrder(u_id);
		List<Comment> noComm = new ArrayList<Comment>();
		List<Comment> yesComm = new ArrayList<Comment>();
		for(Order o:olist){
			
			Comment comm = commDao.getByOid(o.getO_id());
			
			if(comm==null){
				
			}else if(comm.getComm_flag()==0){
				comm.setOrder(o);
				noComm.add(comm);
			}else{
				comm.setOrder(o);
				yesComm.add(comm);
			}
		}
		commMap.put(1,noComm);
		commMap.put(2,yesComm);
		return commMap;
	}

	@Override
	public void writeComm(Comment comm) {
		commDao.update(comm);
	}

}
