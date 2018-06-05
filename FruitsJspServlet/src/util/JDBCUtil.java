package util;


import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 用户名*/
	protected static Connection conn;
	protected static PreparedStatement pstm;
	protected static ResultSet rs;
	
	private static String DB_NAME;
	private static String DB_PWD;
	//连接
	private static String DB_URL;
	//驱动
	private static String DB_DRIVER;
	
	/** 读取工具*/
	private static Properties properties;
	/**初始化数据*/
	static{
		//实例化
		properties = new Properties();
//		加载文件
		InputStream in = 
			JDBCUtil.class.getClassLoader().getResourceAsStream(
					"db.properties");
		try {
			//装载文件
			properties.load(in);
			//赋值
			DB_NAME = properties.getProperty("db_user");
			DB_PWD = properties.getProperty("db_pwd");
			DB_DRIVER = properties.getProperty("db_driver");
			DB_URL = properties.getProperty("db_url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		
		try {
			if(conn==null||conn.isClosed()){
				Class.forName(DB_DRIVER);
				conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeCon(){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 执行动态SQL语句
	 * @param sql 含有参数的动态SQL语句。 
	 * @return 返回PreparedStatement对象
	 */
	public static PreparedStatement executePreparedStatement(String sql)
	{
		try
		{
			pstm = getConn().prepareStatement(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pstm;
	}
	public static int executeUpdate(String sql) 
	{
		int result = 0;
			try {
				pstm = getConn().prepareStatement(sql);
				result = pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return result;
	}
	/**
	 * 执行SELECT SQL语句
	 * @param sql SQL语句，字符串类型
	 * @return ResultSet结果集
	 * @throws SQLException 
	 */
	public static ResultSet executeQuery(String sql)
	{
			try {
				pstm = getConn().prepareStatement(sql);
				rs = pstm.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	}
	/**
	 * 事务回滚
	 */
	public static void rollback() {
		try {
			getConn().rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 关闭数据库连接对象
	 */
	public static void myclose()
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(pstm!= null)
				pstm.close();
			if(conn!=null)
				conn.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	

}
