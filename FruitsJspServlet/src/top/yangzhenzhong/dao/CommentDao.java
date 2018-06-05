package top.yangzhenzhong.dao;

import java.util.List;

import top.yangzhenzhong.bean.Comment;

public interface CommentDao {
	/**
	 * 查看所有评论
	 * @return
	 */
	public List<Comment> getAll();
	/**
	 * 添加评论
	 * @param comm
	 * @return
	 */
	public int add(Comment comm);
	/**
	 * 删除评论
	 * @param comm_id
	 * @return
	 */
	public int delete(int comm_id);
	/**
	 * 获得此用户评论
	 * @param o_id
	 * @return
	 */
	public Comment getByOid(int o_id);
	/**
	 * 写评论
	 * @param comm
	 */
	public void update(Comment comm);
}
