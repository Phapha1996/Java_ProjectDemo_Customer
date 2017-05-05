package dao.intf;

import java.util.List;

import bean.Customer;

public interface Daoitf {

	public void add(Customer customer);

	public void delete(String id);

	public void update(Customer customer);

	public Customer find(String id);
	
	public List getAll();
	
	public List<Customer> pageData(int pageindex,int pagesize);
	
	public int getTotleRecord();

}