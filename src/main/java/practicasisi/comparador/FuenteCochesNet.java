package practicasisi.comparador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet(
	    name = "FuenteCochesNet",
	    urlPatterns = {"/fuenteCochesNet"}
	)

public class FuenteCochesNet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {

	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");

	    response.getWriter().print("Hola pr�ctica de ISI!\r\n");

	    Document doc = ObtenerHTML();
	    response.getWriter().print(doc);
	    
	    ArrayList<ArrayList<String>> salida = ObtenerDatos(doc);
	    
	    response.getWriter().print(salida);
	  }
	
	public Document ObtenerHTML() {
		String url = "https://www.coches.net/segunda-mano/?MakeId=18&ModelId=1202";
		Response response = null;
	    try {
	    	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    	System.out.println("Codigo:" + response.statusCode());
	    } catch (IOException ex) {
	    	System.out.println("Excepci�n al obtener el Status Code: " + ex.getMessage());
	    }
	    
	    
	    Document doc = null;
    	try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
					
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return doc;
	    
	}
	
	
	public ArrayList<ArrayList<String>> ObtenerDatos(Document doc) {
		
		ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList <String>>();
		Element body = doc.body();
		Elements articulos = body.getElementsByClass("contenido-anuncio");
		String prec="";
		for (Element articulo : articulos){
			
				Elements lis = articulo.select("li");
				ArrayList<String> meter= new ArrayList<String>();
				//meter.add(articulo.select("h2").text());
				//prec=lis.select("span:contains(cv)").text();
				//MARCA Y MODELO
				meter.add(articulo.select("h2").text());
				//POTENCIA
				prec=lis.select("span:contains(cv)").text();
				prec = prec.replace("cv","");
				//meter.add(prec);
				//ZONA GEOGRAFICA
				lis = articulo.select("li:contains(Provincia)");
				prec=lis.select("span").text();
				meter.add(lis.select("span").text());
				//FECHA MATRICULACION
				lis = articulo.select("li:contains(Matriculación)");
				prec=lis.select("span").text();
				meter.add(lis.select("span").text());
				//PRECIO
				
				prec=articulo.select(".precio").first().text();
				prec = prec.replace("Con financiación","");
				prec = prec.replace("€","");
				meter.add(prec);
				//KILÓMETROS
				
				lis = articulo.select("li:contains(Kilómetros)");
				prec=lis.select("span").text();
				prec = prec.replace("km","");
//				prec=lis.select("span").text();
				meter.add(prec);
				//El selector span:nth-child(x) busca al padre de span y elige al elemento hijo en la posición x
		  //  datos = "\n"+articulo.select("h2").text();
		    datos.add(meter);
		}
		
		/*
		 * Tipo de combustible.
Potencia y tamaño del motor.
Kilómetros recorridos del vehículo.
Marca y modelo.
Zona geográfica.
Fecha de matriculación.
Precio.
*/
		 
		return datos;
	}
	
}
