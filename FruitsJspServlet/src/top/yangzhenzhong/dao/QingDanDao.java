package top.yangzhenzhong.dao;

import java.sql.SQLException;
import java.util.List;

import top.yangzhenzhong.bean.QingDan;

public interface QingDanDao {
	/**
	 * 查询明细
	 * @param o_id
	 * @return
	 */
	public	List<QingDan> selectQingDanByOid(int o_id);
	/**
	 * 添加清单
	 * @throws SQLException 
	 */
	public void addQingDan(QingDan qd) throws SQLException;
}
