package JunitTest;

import org.junit.Test;

import service.impl.BusinessService;

public class ServiceTest {

	@Test
	public void testpagecustomer(){
		BusinessService bs = new BusinessService();
		bs.getPageData(null);
	}
	
}
