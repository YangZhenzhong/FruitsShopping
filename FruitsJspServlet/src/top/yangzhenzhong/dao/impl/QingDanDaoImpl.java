package top.yangzhenzhong.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.QingDan;
import top.yangzhenzhong.dao.FruitDao;
import top.yangzhenzhong.dao.QingDanDao;
import util.DaoFactory;
import util.JDBCUtil;

public class QingDanDaoImpl implements QingDanDao {
	FruitDao fDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.FruitDaoImpl", FruitDao.class);
	@Override
	public List<QingDan> selectQingDanByOid(int o_id) {
		List<QingDan> qList = new ArrayList<QingDan>(); 
		String sql = "select * from qingdan where o_id="+o_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				QingDan qd = new QingDan();
				qd.setFruit(fDao.getById(rs.getInt("f_id")));
				qd.setO_id(rs.getInt("o_id"));
				qd.setQd_id(rs.getInt("qd_id"));
				qd.setQd_num(rs.getInt("qd_num"));
				qd.setQd_price(rs.getInt("qd_price"));
				qList.add(qd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}
	@Override
	public void addQingDan(QingDan qd) throws SQLException {
		String sql = "insert into qingdan(o_id,f_id,qd_num,qd_price) values("+qd.getO_id()+","+qd.getFruit().getF_id()+","+qd.getQd_num()+","+qd.getQd_price()+")";
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		pstm.executeUpdate();
	}

}
