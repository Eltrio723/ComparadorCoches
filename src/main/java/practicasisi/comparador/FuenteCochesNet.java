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

	    response.getWriter().print("Hola práctica de ISI!\r\n");

	    Document doc = ObtenerHTML();
	    response.getWriter().print(doc);
	    
	    ArrayList<ArrayList<String>> salida = SacarDatos(doc);
	    
	    response.getWriter().print(salida);
	  }
	
	public Document ObtenerHTML() {
		String url = "https://www.coches.net/segunda-mano/?MakeId=18&ModelId=1202";
		Response response = null;
	    try {
	    	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    	System.out.println("Codigo:" + response.statusCode());
	    } catch (IOException ex) {
	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
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
	
	
	public ArrayList<ArrayList<String>> SacarDatos(Document doc) {
		
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		
		Element body = doc.body();
		Elements divPrecios = body.getElementsByClass("mt-AdPrice-amount");
		//Ciudad, combustible, año, km
		Elements divAtributos = body.getElementsByClass("mt-CardAd-attribute");

		
		ArrayList<String> precios = new ArrayList<String>();
		ArrayList<String> atributos = new ArrayList<String>();
		//String documento = "";
		for(Element precio : divPrecios) {
			precios.add(precio.text());
			//documento += precio.text();
		}
		
		for(Element atributo : divAtributos) {
			atributos.add(atributo.text());
		}
		
		tabla.add(precios);
		tabla.add(atributos);
		
		return tabla;
	}
	
}
