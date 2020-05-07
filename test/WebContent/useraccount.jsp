<%@page import="com.oop.customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>    
<body>

<% customer cus = (customer) request.getAttribute("cus");
%>

 	
	

	<h4>patient id</h4>
	<%out.println(cus.getPatienID()); %> <br>
	<h4>bill id</h4>
	<%=cus.getBillID() %> <br>
	<h4>Amount</h4>
	<%=cus.getAmount() %><br>
	
	<a href="updatecustomer.jsp">update</a>
	<a href="DelUserServlet?billid=<%=cus.getBillID() %>">delete</a>
	
	<c:url value="updatecustomer.jsp" var="cusupdate">
		
		<c:param name=""></c:param>
	
	 </c:url>
	
	<a href="">
	<input type="button" name="update" value="update my details">
	</a>

</body>
</html>