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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

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
	public String getOrders(){
        
		ArrayList<Order> orders = orfac.getOrders();
		String jsonOrders = new Gson().toJson(orders);
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("orders", jsonOrders);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj.toString().replace("\\","");
	}
	
	
}
