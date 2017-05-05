<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看用户</title>
    

  </head>
  
  <body style="text-align: center;">
  
  <c:choose>
  <c:when test="${!empty(page.list) }">
  <table align="center" border=1 >
  	<tr>
  		<td>姓名</td>
  		<td>性别</td>
  		<td>生日</td>
  		<td>电话</td>
  		<td>邮箱</td>
  		<td>爱好</td>
  		<td>客户类型</td>
  		<td>客户简介</td>
  	<tr>
  	<c:forEach items="${page.list }" var="c">
  		<tr>
  			<td>${c.name }</td>
  			<td>${c.gender }</td>
  			<td>${c.birthday }</td>
  			<td>${c.cellphone }</td>
  			<td>${c.email }</td>
  			<td>${c.preference }</td>
  			<td>${c.type }</td>
  			<td>${c.description }</td>
  			<td>
  			<a href="">删除</a>  <a href="">修改</a>
  			</td>
  		</tr>
  	</c:forEach>
  	
  </table>
  </c:when>
  <c:otherwise>
  <h1>对不起，页面还没有任何的数据</h1>
  </c:otherwise>
  </c:choose>
  <br><br>
  
  	当前[${page.pagenum }]页&nbsp;&nbsp;&nbsp;
  	<c:if test="${page.pagenum>1 }">
  	<a href="${pageContext.request.contextPath }/servlet/WatchCustomerServlet?pagenum=${page.pagenum-1}">上一页</a>&nbsp;
  	</c:if>
  	<c:forEach var="pagenum" begin="${page.startpage }" end="${page.endpage }">
  		[<a href="${pageContext.request.contextPath }/servlet/WatchCustomerServlet?pagenum=${pagenum}">${pagenum }</a>]
  	</c:forEach>
  	 &nbsp;
  	 <c:if test="${page.pagenum<page.totlepage }">
  	 <a href="${pageContext.request.contextPath }/servlet/WatchCustomerServlet?pagenum=${page.pagenum+1}">下一页</a>
  	 </c:if>
  	&nbsp;&nbsp;&nbsp;总共[${page.totlepage }]页，共[${page.totlerecord }]条记录
  	<input type="text" name="pagenum" style="width:25px">
  	<input type="button" value=" go ">
  	
  </body>
</html>
