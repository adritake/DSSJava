package REST;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import facade.ProductoFacade;
import servidor.Producto;

@Path("/producto")
public class Productos {

	private ProductoFacade profac;
	
	public Productos() {
		profac = new ProductoFacade();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Producto> getProductos() {
		
		ArrayList<Producto> productos = profac.getProductos();
		return productos;
		
	}
	
	
	
}
