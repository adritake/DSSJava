<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de las orders</title>
</head>
<body>

	<h1>LISTA DE ORDERS</h1>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="servidor.Order" %>
	<%
	
		ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
		for( int i = 0; i < orders.size(); i++)
			out.println("<p>" + orders.get(i) + "</p>");
	
	%>
</body>
</html>