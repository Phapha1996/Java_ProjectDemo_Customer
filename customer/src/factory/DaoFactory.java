package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao.intf.Daoitf;
import exception.ServiceException;

public class DaoFactory {

	private static String dao = null;
	
	static{
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("Dao.properties");
			Properties pro = new Properties();
			pro.load(in);
			dao = pro.getProperty("dao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static Daoitf getDao(){
		try{
				return (Daoitf) Class.forName(dao).newInstance();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
	
	
}
