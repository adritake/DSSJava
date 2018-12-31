package REST;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import facade.OrderFacade;
import servidor.Order;
import servidor.Usuario;

@Path("/order")
public class Orders{

	private OrderFacade orfac;
	
	public Orders() {
		orfac = new OrderFacade();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Order> getOrders(){
        
		ArrayList<Order> orders = orfac.getOrders();
		
		return orders;
	}
	
	
}
