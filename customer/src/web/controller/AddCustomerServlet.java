package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import service.impl.BusinessService;
import utils.WebUtils;

public class AddCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	try{
		Customer c = WebUtils.requestToBean(request, Customer.class);
		c.setId(WebUtils.makeID());
		BusinessService bs = new BusinessService();
		bs.addCustomer(c);
		request.setAttribute("message", "添加成功");
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("message", "添加失败");
	}
		
	request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
