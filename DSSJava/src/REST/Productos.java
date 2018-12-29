package REST;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.ProductoFacade;
import servidor.Order;
import servidor.Producto;

public class Productos extends HttpServlet {

	private ProductoFacade profac;
	
	public Productos() {
		profac = new ProductoFacade();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		ArrayList<Producto> productos = profac.getProductos();
		
		
		request.setAttribute("productos", productos);
			
		
        request.getRequestDispatcher("/WEB-INF/ListaProductos.jsp").forward(request, response);

	}
	
}
