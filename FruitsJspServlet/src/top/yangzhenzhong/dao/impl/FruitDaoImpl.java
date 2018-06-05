package top.yangzhenzhong.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.dao.FruitDao;
import top.yangzhenzhong.dao.SortDao;
import util.DaoFactory;
import util.JDBCUtil;
import util.SelectUtil;

public class FruitDaoImpl implements FruitDao {
	SortDao sortDao = DaoFactory.getInstance().createDao("top.yangzhenzhong.dao.impl.SortDaoImpl", SortDao.class);
	/**
	 * 分页查询
	 */
	@Override
	public List<Fruit> getPage(int page, int rows) {
		List<Fruit> list = new ArrayList<Fruit>();
		String sql = "select * from fruit LIMIT "+(page-1)*rows+","+rows;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Fruit f = new Fruit();
				f.setF_guige(rs.getString("f_guige"));
				f.setF_id(rs.getInt("f_id"));
				f.setF_kucun(rs.getInt("f_kucun"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_tuwen(rs.getString("f_tuwen"));
				f.setF_yuanjia(rs.getInt("f_yuanjia"));
				f.setS(sortDao.getById(rs.getInt("s_id")));
				f.setF_pic(rs.getString("f_pic"));
				f.setF_name(rs.getString("f_name"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return list;
	}

	@Override
	public List<Fruit> getBySortId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fruit> getByFruit(SelectUtil sUtil) {
		List<Fruit> fList = new ArrayList<Fruit>();
		String sql = "select * from fruit where s_id="+sUtil.getS_id()+" and f_name like ('%"+sUtil.getKey()+"%') order by "+sUtil.getColName()+" "+sUtil.getRule()+"";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Fruit f = new Fruit();
				f.setF_guige(rs.getString("f_guige"));
				f.setF_id(rs.getInt("f_id"));
				f.setF_kucun(rs.getInt("f_kucun"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_tuwen(rs.getString("f_tuwen"));
				f.setF_yuanjia(rs.getInt("f_yuanjia"));
				f.setS(sortDao.getById(rs.getInt("s_id")));
				f.setF_pic(rs.getString("f_pic"));
				f.setF_name(rs.getString("f_name"));
				fList.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return fList;
	}

	@Override
	public int addFruit(Fruit f) {
		
		int row = 0 ;
		
		String sql = "insert into fruit(f_guige,f_kucun,f_price,f_tuwen,f_yuanjia,s_id,f_pic,f_name)values('"+f.getF_guige()+"',"+f.getF_kucun()+","+f.getF_price()+",'"+f.getF_tuwen()+"',"+f.getF_yuanjia()+","+f.getS().getS_id()+",'"+f.getF_pic()+"','"+f.getF_name()+"')";
		row = JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
		return row;
	}

	@Override
	public int deleteFruit(int f_id) {
		int row=0;
		String sql ="delete from fruit where f_id="+f_id;
		row = JDBCUtil.executeUpdate(sql);
		return row;
	}

	@Override
	public void update(Fruit f) {
		String sql = "update fruit set s_id="+f.getS().getS_id()+",f_guige='"+f.getF_guige()+"',f_tuwen='"+f.getF_tuwen()+"',f_kucun="+f.getF_kucun()+",f_price="+f.getF_price()+",f_yuanjia="+f.getF_yuanjia()+",f_pic='"+f.getF_pic()+"'  where f_id="+f.getF_id();
		JDBCUtil.executeUpdate(sql);
		JDBCUtil.myclose();
	}

	@Override
	public void buyOrAdd(int f_id, int num,String opt) {
		
	}

	@Override
	public int getNum() {
			int num=0;
			String sql = "select count(f_id) as num from fruit";
			ResultSet rs = JDBCUtil.executeQuery(sql);
			try {
				if(rs.next()){
					num=rs.getInt("num");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return num;
	}
	/**
	 * 获得某个商品信息
	 */
	@Override
	public Fruit getById(int f_id) {
		Fruit f= null;
		String sql = "select * from fruit where f_id="+f_id;
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			if(rs.next()){
				f= new Fruit();
				f.setF_guige(rs.getString("f_guige"));
				f.setF_id(rs.getInt("f_id"));
				f.setF_kucun(rs.getInt("f_kucun"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_tuwen(rs.getString("f_tuwen"));
				f.setF_yuanjia(rs.getInt("f_yuanjia"));
				f.setS(sortDao.getById(rs.getInt("s_id")));
				f.setF_pic(rs.getString("f_pic"));
				f.setF_name(rs.getString("f_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Fruit> getAll(SelectUtil sUtil) {
		List<Fruit> fList = new ArrayList<Fruit>();
		String sql = "select * from fruit where  f_name like ('%"+sUtil.getKey()+"%') order by "+sUtil.getColName()+" "+sUtil.getRule()+"";
		ResultSet rs = JDBCUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Fruit f = new Fruit();
				f.setF_guige(rs.getString("f_guige"));
				f.setF_id(rs.getInt("f_id"));
				f.setF_kucun(rs.getInt("f_kucun"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_tuwen(rs.getString("f_tuwen"));
				f.setF_yuanjia(rs.getInt("f_yuanjia"));
				f.setS(sortDao.getById(rs.getInt("s_id")));
				f.setF_pic(rs.getString("f_pic"));
				f.setF_name(rs.getString("f_name"));
				fList.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.myclose();
		}
		return fList;
	}
	/**
	 * 减少商品数量
	 * @throws SQLException 
	 */
	@Override
	public void updateNum(int f_id, int c_num) throws SQLException {
		String sql = "update fruit set f_kucun=f_kucun-"+c_num+" where f_id="+f_id;
		PreparedStatement pstm = JDBCUtil.executePreparedStatement(sql);
		pstm.executeUpdate();
	}


}
