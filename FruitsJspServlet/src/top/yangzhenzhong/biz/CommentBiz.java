package top.yangzhenzhong.biz;

import java.util.List;
import java.util.Map;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.dao.CommentDao;
import top.yangzhenzhong.dao.OrderDao;
import util.DaoFactory;

public interface CommentBiz {
	CommentDao commDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.CommentDaoImpl",CommentDao.class);
	OrderDao oDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.OrderDaoImpl",OrderDao.class);
	/**
	 * 获得所有评论
	 * @return
	 */
	public List<Comment> getAll();
	/**
	 * 删除指定id
	 * @param comm_id
	 */
	public void delete(int comm_id);
	/**
	 * 添加评论
	 */
	public void add(Comment comm);
	/**
	 * 查询该用户的评论
	 */
	public Map<Integer,Object> getUComment(int u_id);
	/**
	 * 用户评论
	 */
	public void writeComm(Comment comm);
}
