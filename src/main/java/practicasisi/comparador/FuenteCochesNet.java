package practicasisi.comparador;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

	    Document doc = prueba();
	    
	    response.getWriter().print(doc);
	  }
	
	public Document prueba() {
		String url = "https://www.milanuncios.com/citroen-de-segunda-mano-en-granada/?fromSearch=1&demanda=n&combustible=gasolina&puertas=5";
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
	
}
