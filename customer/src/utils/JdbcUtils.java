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
	
	//��������
	static{
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");//��ȡproperties�ļ���ģ�����
			Properties pro = new Properties();
			pro.load(in);
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			
			Class.forName(driver);  //��������
			
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	
	//�Ӽ��ص������еõ����Ӷ���
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	
	//�ͷ����ݿ��ռ����Դ
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
