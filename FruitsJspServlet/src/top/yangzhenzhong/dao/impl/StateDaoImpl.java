package top.yangzhenzhong.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import top.yangzhenzhong.bean.State;
import top.yangzhenzhong.dao.StateDao;
import util.JDBCUtil;

public class StateDaoImpl implements StateDao {

	@Override
	public List<State> getAll() {
		List<State> list = new ArrayList<State>();
		String sql = "select * from state";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				State state = new State();
				state.setName(rs.getString("name"));
				state.setState_id(rs.getInt("state_id"));
				list.add(state);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.myclose();
		}
		return list;
	}

	@Override
	public State getState(int state_id) {
		State state= null;
		String sql = "select * from state where state_id="+state_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				state = new State();
				state.setName(rs.getString("name"));
				state.setState_id(rs.getInt("state_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

}
