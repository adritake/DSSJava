<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="facade.ProductoFacade" %>
	<%@ page import="servidor.Producto" %>
	<%
	
		ProductoFacade profac = new ProductoFacade();
		ArrayList<Producto> productos = profac.getProductos();
		
		for(Producto p: productos)
			out.println("<p>" + p +"</p>");
	
	%>
</body>
</html>