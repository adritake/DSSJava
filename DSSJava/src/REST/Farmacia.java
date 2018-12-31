package REST;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import facade.FarmaciaFacade;
import servidor.Producto;
import servidor.Usuario;


@Path("/farmacia")
public class Farmacia{
	
	private FarmaciaFacade farmafac;
	
	public Farmacia() {
		farmafac = new FarmaciaFacade();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<servidor.Farmacia> getFarmacias(){
		
		ArrayList<servidor.Farmacia> farmacias = farmafac.getFarmacias();
		
		return farmacias;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addFarmacia(servidor.Farmacia far) {
		
		
		boolean added = farmafac.newFarmacia(far);
			
		if (added)
			return Response.status(201).entity("Added").build();
		else
			return Response.status(409).entity("Could not add").build();

	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateFarmacia(servidor.Farmacia far) {
		
		
		boolean updated = farmafac.updateFarmacia(far);
		
		if (updated)
			return Response.status(200).entity("Updated").build();
		else
			return Response.status(400).entity("Could not update").build();

	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteFarmacia(servidor.Farmacia far) {
		
		
		boolean deleted = farmafac.deleteFarmacia(far);
		
		if (deleted)
			return Response.status(200).entity("Deleted").build();
		else
			return Response.status(400).entity("Could not delete").build();

	}

}
