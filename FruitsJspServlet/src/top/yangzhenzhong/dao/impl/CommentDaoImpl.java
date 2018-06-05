package top.yangzhenzhong.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.dao.CommentDao;
import top.yangzhenzhong.dao.OrderDao;
import util.DaoFactory;
import util.JDBCUtil;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getAll() {
		OrderDao oDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.OrderDaoImpl", OrderDao.class);
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from comment";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Comment comm = new Comment();
				comm.setComm_comment(rs.getString("comm_comment"));
				comm.setComm_date(rs.getDate("comm_date"));
				comm.setComm_flag(rs.getInt("comm_flag"));
				comm.setComm_id(rs.getInt("comm_id"));
				comm.setComm_pointer(rs.getInt("comm_pointer"));
				comm.setOrder(oDao.getByOid(rs.getInt("o_id")));
				list.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return list;
	}

	@Override
	public int add(Comment comm) {
		int rows = 0;
		String sql = "insert into comment(o_id,comm_comment,comm_date,comm_flag,comm_pointer) values(?,?,SYSDATE(),?,?)";
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		try {
			pstm.setInt(1,comm.getOrder().getO_id());
			pstm.setString(2,comm.getComm_comment());
			pstm.setInt(3,comm.getComm_flag());
			pstm.setInt(4,comm.getComm_pointer());
			rows = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(int comm_id) {
		int rows = 0;
		String sql = "delete from comment where comm_id="+comm_id;
		rows = JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
		return rows;
	}
	public Comment getByOid(int o_id){
		Comment comm = null;
		String sql = "select * from comment where o_id="+o_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				comm = new Comment();
				comm.setComm_comment(rs.getString("comm_comment"));
				comm.setComm_date(rs.getDate("comm_date"));
				comm.setComm_flag(rs.getInt("comm_flag"));
				comm.setComm_id(rs.getInt("comm_id"));
				comm.setComm_pointer(rs.getInt("comm_pointer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comm;
	}

	@Override
	public void update(Comment comm) {
		String sql = "update comment set comm_comment='"+comm.getComm_comment()+"',comm_flag="+comm.getComm_flag()+" where comm_id="+comm.getComm_id();
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}
}
