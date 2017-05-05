package JunitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import service.impl.BusinessService;
import bean.Customer;
import dao.impl.CustomerDao;
import dao.intf.Daoitf;
import factory.DaoFactory;

public class DaoTest {
		
		@Test
		public void testAdd(){
			
			try{
			BusinessService bs = new BusinessService();
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("1996-1-17");
			for(int i=0;i<100;i++){
			Customer co = new Customer();
			co.setId("1234588"+i);
			co.setName("fage"+i);
			co.setBirthday(date);
			co.setEmail("1110554416@q.com"+i);
			co.setCellphone("13977726588");
			co.setPreference("我爱苍井空");
			co.setType("重要客户,VIP");
			co.setGender("男");
			co.setDescription("哈哈");
			bs.addCustomer(co);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@Test
		public void test_getAll(){
			CustomerDao dao = new CustomerDao();
			List<Customer> list = dao.getAll();
			
		}
		
		
		@Test
		public void testpageInit(){
			CustomerDao dao = new CustomerDao();
			List<Customer> list = dao.pageData(0, 5);
			
		}
		
		
		@Test
		public void testTotlerecord(){
			CustomerDao dao = new CustomerDao();
			dao.getTotleRecord();
		}
		
		@Test
		public void testdate(){
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse("1996-1-17");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

}
