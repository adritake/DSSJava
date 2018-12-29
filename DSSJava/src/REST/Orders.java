package REST;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.OrderFacade;
import servidor.Order;
import servidor.Usuario;

public class Orders extends HttpServlet {

	private OrderFacade orfac;
	
	public Orders() {
		orfac = new OrderFacade();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		ArrayList<Order> orders = orfac.getOrders();
		
		
		request.setAttribute("orders", orders);
			
		
        request.getRequestDispatcher("/WEB-INF/ListaOrders.jsp").forward(request, response);

	}
	
	
}
