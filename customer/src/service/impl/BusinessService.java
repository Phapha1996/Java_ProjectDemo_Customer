package service.impl;

import java.util.List;

import bean.Customer;
import bean.Page;
import dao.intf.Daoitf;
import exception.ServiceException;
import factory.DaoFactory;

public class BusinessService {

	
	public void addCustomer(Customer  customer){
			Daoitf dao = DaoFactory.getDao();
			dao.add(customer);
		
	}
	
	
	public List watchCustomer(){					//查看所有的用户
		return DaoFactory.getDao().getAll();
	}

	
	
	public Page getPageData(String pagenum){

		Daoitf dao = DaoFactory.getDao();
		if(pagenum==null){
			Page page = new Page(dao.getTotleRecord(),1);
			List<Customer> list = dao.pageData(page.getStartindex(), page.getPAGESIZE());
			page.setList(list);
			return page;
		}
			
		Page page = new Page(dao.getTotleRecord(),Integer.parseInt(pagenum));
		List<Customer> list = dao.pageData(page.getStartindex(), page.getPAGESIZE());
		page.setList(list);
		
		return page;
	}
	
	
}
