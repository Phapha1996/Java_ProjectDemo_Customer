package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	private static String username = null;
	private static String password = null;
	private static String driver = null;
	private static String url = null;	
	
	//加载驱动
	static{
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");//读取properties文件的模板代码
			Properties pro = new Properties();
			pro.load(in);
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			
			Class.forName(driver);  //加载驱动
			
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	
	//从加载的驱动中得到连接对象
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	
	//释放数据库的占用资源
	public static void release(Connection con,Statement st,ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				st = null;
			}
		}
	
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				con = null;
			}
		}
	}
	
}
