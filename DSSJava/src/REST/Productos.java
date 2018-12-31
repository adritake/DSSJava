package REST;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addProducto(Producto pro) {
		
		
		boolean added = profac.newProducto(pro);
			
		if (added)
			return Response.status(201).entity("Added").build();
		else
			return Response.status(409).entity("Could not add").build();

	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateProducto(Producto pro) {
		
		
		boolean updated = profac.updateProducto(pro);
		if (updated)
			return Response.status(200).entity("Updated").build();
		else
			return Response.status(400).entity("Could not update").build();

	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteProducto(Producto pro) {
		
		
		boolean deleted = profac.deleteProducto(pro);
		
		if (deleted)
			return Response.status(200).entity("Deleted").build();
		else
			return Response.status(400).entity("Could not delete").build();

	}
	
	
	
}
