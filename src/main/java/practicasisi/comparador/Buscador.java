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
			Coleccion coleccion = new Coleccion();
			String marca = (String) request.getParameter("marca");
			String potencia = (String) request.getParameter("potencia");
			String combustible = (String) request.getParameter("combustible");
			String provincia = (String) request.getParameter("provincia");
			String fecha = (String) request.getParameter("fecha");
			String precio = (String) request.getParameter("precio");
			String km = (String) request.getParameter("km");
			//System.out.println(marca);
			
			//API api=new API();
			//api.ObtenerDatosParaJSON(marca, potencia,combustible, provincia, fecha, precio, km);
			PrimeraFuente primeraFuente = new PrimeraFuente();
			Coleccion coleccion1 = primeraFuente.Buscar(marca, potencia,combustible, provincia, fecha, precio, km);
			
			SegundaFuente segundaFuente = new SegundaFuente();
			Coleccion coleccion2 = segundaFuente.Buscar(marca, potencia,combustible, provincia, fecha, precio, km);
			
			TerceraFuente terceraFuente=new TerceraFuente();
			Coleccion coleccion3 = terceraFuente.Buscar(marca, potencia,combustible, provincia, fecha, precio, km);
			
			coleccion.merge(coleccion1);
			coleccion.merge(coleccion2);
			coleccion.merge(coleccion3);
			
			request.setAttribute("ofertas", coleccion.getOfertas());
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			}
		catch(Exception ex){
			
		}
	  }
	
	
	
	
}
