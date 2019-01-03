package REST;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import facade.ProductoFacade;
import servidor.Producto;
import servidor.Usuario;

@Path("/producto")
public class Productos {

	private ProductoFacade profac;
	
	public Productos() {
		profac = new ProductoFacade();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getProductos() {
		
		ArrayList<Producto> productos = profac.getProductos();
		String jsonProductos = new Gson().toJson(productos);
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("productos", jsonProductos);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj.toString().replace("\\","");
		
	}
	
	@PUT
	public Response addProducto(@PathParam("aniadirNombre") String nombre) {
		
		Producto pro = new Producto(0,nombre);
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
	public Response deleteProducto(@PathParam("borrarID") String id) {
		
		Producto pro = new Producto(Integer.parseInt(id),"");
		
		boolean deleted = profac.deleteProducto(pro);
		
		if (deleted)
			return Response.status(200).entity("Deleted").build();
		else
			return Response.status(400).entity("Could not delete").build();

	}
	
	
	
}
