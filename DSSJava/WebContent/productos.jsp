<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Productos</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear">
    <div id="hgroup">
      <h1><a href="#">Productos</a></h1>
    </div>
    <nav>
      <ul>
        <li><a href="productos.jsp">Productos</a></li>
        <li><a href="farmacias.jsp">Farmacias</a></li>
        <li><a href="usuarios.jsp">Usuarios</a></li>
        <li><a href="orders.jsp">Encargos</a></li>
      </ul>
    </nav>
  </header>
</div>
<!-- content -->
<div class="wrapper row2">
	<h2>Listado de productos</h2>
   <ul>
        <%@ page import="java.util.ArrayList" %>
		<%@ page import="facade.ProductoFacade" %>
		<%@ page import="servidor.Producto" %>
		<%
		
			ProductoFacade profac = new ProductoFacade();
			
			String aniadirNombre = request.getParameter("aniadirNombre");
			String borrarID = request.getParameter("borrarID");
			String modificarID = request.getParameter("modificarID");
			String modificarNombre = request.getParameter("modificarNombre");

		
			if(aniadirNombre != null){
				Producto p = new Producto(0,aniadirNombre);
				profac.newProducto(p);
			}
			if(borrarID != null){
				Producto p = new Producto(Integer.parseInt(borrarID),"");
				profac.deleteProducto(p);
			}
			if(modificarID != null && modificarNombre != null){
				Producto p = new Producto(Integer.parseInt(modificarID),modificarNombre);
				profac.updateProducto(p);
			}
			
			ArrayList<Producto> productos = profac.getProductos();
			
			for(Producto p: productos)
				out.println("<li>" + p +"</li>");
		
		%>
   </ul>
</div>
<div class="wrapper row2">
	
	<table>
		<tr>
			<th>
				A�adir producto:
				<form action="productos.jsp" method="post">
					<input type="text" name="aniadirNombre" placeholder="Nombre"><br>
					<input type="submit" value="A�adir">
				</form>	
			</th>
			<th>
				Borrar producto:
				<form action="productos.jsp" method = "post">
					<input type="text" name="borrarID" placeholder="ID"><br>
					<input type="submit" value="Borrar">
				</form>
			</th>
			<th>
				Modificar producto:
				<form action="productos.jsp" method = "post">
					<input type="text" name="modificarID" placeholder="ID"><br>
					<input type="text" name="modificarNombre" placeholder="Nuevo nombre"><br>
					<input type="submit" value="Modificar">
				</form>
			</th>
		</tr>
	</table>

</div>
<!-- Footer -->
<div class="wrapper row3">
  <footer id="footer" class="clear">
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
  </footer>
</div>
</body>
</html>