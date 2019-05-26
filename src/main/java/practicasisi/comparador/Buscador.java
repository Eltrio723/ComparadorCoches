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

import com.google.gson.JsonObject;

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
		String datos="";
		
		try {
			ArrayList<ArrayList<String>> datosMatriz= new ArrayList<ArrayList<String>>();
			Coleccion coleccion = new Coleccion();
			String marca = (String) request.getParameter("marca");
			String potencia = (String) request.getParameter("potencia");
			String combustible = (String) request.getParameter("combustible");
			String provincia = (String) request.getParameter("provincia");
			String fecha = (String) request.getParameter("fecha");
			String precio = (String) request.getParameter("precio");
			String km = (String) request.getParameter("km");
			//System.out.println(marca);
			
			API api=new API();
			datos=api.ObtenerDatosParaJSON(marca);

			JsonObject js=api.CambioJSON(datos);
			//js.get("totalCount").getAsString();
			//System.out.println(js.get("totalCount").getAsString());
			datosMatriz=api.obtenerDatos(js);
			Coleccion coleccion4= api.Buscar(datosMatriz);
			
			PrimeraFuente primeraFuente = new PrimeraFuente();
			Coleccion coleccion1 = primeraFuente.Buscar(marca);
			
			SegundaFuente segundaFuente = new SegundaFuente();
			Coleccion coleccion2 = segundaFuente.Buscar(marca);
			
			TerceraFuente terceraFuente=new TerceraFuente();
			Coleccion coleccion3 = terceraFuente.Buscar(marca);
			
			coleccion.merge(coleccion1);
			coleccion.merge(coleccion2);
			coleccion.merge(coleccion3);
			coleccion.merge(coleccion4);
			coleccion.ponderar(Integer.parseInt(potencia), combustible, provincia, Integer.parseInt(fecha), Integer.parseInt(precio), Integer.parseInt(km));
			
			request.setAttribute("ofertas", coleccion.getOfertas());
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			}
		catch(Exception ex){
			
		}
	  }
	
	
	
	
}
