package REST;

import java.io.IOException;
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

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import facade.UsuarioFacade;
import servidor.Producto;
import servidor.Usuario;

@Path("/usuario")
public class Usuarios{

	UsuarioFacade userfac;
	
	public Usuarios() {
		userfac = new UsuarioFacade();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getUsuarios(){
        
			
		ArrayList<Usuario> usuarios = userfac.getUsuarios();
		String jsonUsuarios = new Gson().toJson(usuarios);
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("usuarios", jsonUsuarios);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj.toString().replace("\\","");

	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addUsuario(Usuario usr) {
		
		
		boolean added = userfac.newUsuario(usr);
			
		if (added)
			return Response.status(201).entity("Added").build();
		else
			return Response.status(409).entity("Could not add").build();

	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateUsuario(Usuario usr) {
		
		
		boolean updated = userfac.updateUsuario(usr);
		
		if (updated)
			return Response.status(200).entity("Updated").build();
		else
			return Response.status(400).entity("Could not update").build();

	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteUsuario(Usuario usr) {
		
		
		boolean deleted = userfac.deleteUsuario(usr);
		
		if (deleted)
			return Response.status(200).entity("Deleted").build();
		else
			return Response.status(400).entity("Could not delete").build();

	}
	
}
