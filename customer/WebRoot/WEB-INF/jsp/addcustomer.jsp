<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="${pageContext.request.contextPath }/js/customer.js"></script>
	
  </head>
  
  <body style="text-align: center;" onload="pageInit()">
 
  <form action="${pageContext.request.contextPath }/servlet/AddCustomerServlet" method="post" name="customer" id="customer" onsubmit="return check()">
  <table border=1 align="center">
  <tr>
  <td>客户姓名:</td>
  <td><input type="text" name="name"></td>
  </tr>
  
  <tr>
  <td>性别：</td>
  <td>男<input type="radio" name="gender" value="男">女<input type="radio" name="gender" value="女"></td>
  </tr>
  
  <tr>
  <td>生日：</td>
  <td>
  	<select  id="year">
  		<option value="1900">1900</option>
  	</select>年
  	
  	<select  id="month">
  	<option value="1">01</option>
  	</select>月
  	
  	<select  id="day">
  	<option value="1">01</option>
  	</select>日
  	
  </td>
  </tr>  
  
  <tr>
  <td>手机：</td>
  <td><input type="text" name="cellphone"></td>
  </tr>
  
  <tr>
  <td>邮箱：</td>
  <td><input type="text" name="email"></td>
  </tr>
  
  <tr>
  <td>爱好：</td>
  <td>
  		<c:forEach var="pre" items="${preference }">
  			<input type="checkbox" name="pre" value="${pre }">${pre }
  		</c:forEach>
  </td>
  </tr>
  
  <tr>
  <td>客户类型：</td>
  <td>
 	<c:forEach var="type" items="${customerType }">
  		<input type="radio" name="type" value="${type }">${type }
  	</c:forEach>
  </td>
  </tr>
  
  <tr>
  <td>客户备注：</td>
  <td><textarea name="description"rows="5" cols="30"></textarea></td>
  </tr>
  
  </table>
  <br><br>
  <center><input type="reset" value="清除"><input type="submit" value="添加" ></center> 
  </form>
  </body>
</html>
