package practicasisi.comparador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet(
	    name = "Buscador",
	    urlPatterns = {"/buscador"}
	)

public class Buscador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {

		try {
			String marca = (String) request.getParameter("marca");
			String potencia = (String) request.getParameter("potencia");
			String provincia = (String) request.getParameter("provincia");
			String fecha = (String) request.getParameter("fecha");
			String precio = (String) request.getParameter("precio");
			String km = (String) request.getParameter("km");

			FuenteMilAnuncios fuenteMilAnuncios = new FuenteMilAnuncios();
			fuenteMilAnuncios.Buscar(marca, potencia, provincia, fecha, precio, km);
			
			FuenteCochesNet fuenteCochesNet = new FuenteCochesNet();
			fuenteCochesNet.Buscar(marca, potencia, provincia, fecha, precio, km);
			
			}
		catch(Exception ex){
			
		}
	  }
	
	
	
}
