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

import facade.UsuarioFacade;
import servidor.Usuario;

@Path("/usuario")
public class Usuarios{

	UsuarioFacade userfac;
	
	public Usuarios() {
		userfac = new UsuarioFacade();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Usuario> getUsuarios(){
        
		ArrayList<Usuario> usuarios = userfac.getUsuarios();
		
		return usuarios;

	}
	
}
