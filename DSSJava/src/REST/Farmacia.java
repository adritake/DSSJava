package REST;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.FarmaciaFacade;
import servidor.Usuario;

public class Farmacia extends HttpServlet{
	
	private FarmaciaFacade farmafac;
	
	public Farmacia() {
		farmafac = new FarmaciaFacade();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<servidor.Farmacia> farmacias = farmafac.getFarmacias();
		
		request.setAttribute("farmacias", farmacias);
        
        request.getRequestDispatcher("/WEB-INF/ListaFarmacias.jsp").forward(request, response);

	}

}
