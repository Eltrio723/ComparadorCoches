package practicasisi.comparador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class TerceraFuente
 */
@WebServlet(
	    name = "TerceraFuente",
	    urlPatterns = {"/tercerafuente"}
	)
public class TerceraFuente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
    @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {

	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    ArrayList<ArrayList<String>> salida =new ArrayList<ArrayList<String>>();
	    response.getWriter().print("Hola pr�ctica de ISI!\r\n");

	    Document doc = ObtenerHTML();
	    //response.getWriter().print(doc);
	    
	    salida= ObtenerDatos(doc);
	    for(ArrayList<String> linea : salida) {
	    	response.getWriter().print(linea+"\n");
	    }
	    //response.getWriter().print(salida);
	  }
public ArrayList<ArrayList<String>> ObtenerDatos(Document doc) {
		
		ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList <String>>();
		Element body = doc.body();
		Elements articulos = body.getElementsByClass("script__pill");
		//mt-Card-hover  mt-Card--topAd
		String prec="";
		
		for (Element articulo : articulos){
			
				Elements lis = articulo.select("h2");
				ArrayList<String> meter= new ArrayList<String>();
				//meter.add(articulo.select("h2").text());
				//prec=lis.select("span:contains(cv)").text();
				//MARCA Y MODELO
				meter.add(articulo.getElementsByClass("make-model-version").text());
				
				//POTENCIA
				prec=articulo.getElementsByClass("cv").text();
				prec = prec.replace("cv","");
				meter.add(prec);
				//COMBUSTIBLE
				meter.add(articulo.getElementsByClass("gas").text());
				//ZONA GEOGRAFICA
				
				meter.add(articulo.getElementsByClass("location").text());
				//FECHA MATRICULACION
				
				meter.add(articulo.getElementsByClass("year").text());
				//PRECIO
				
				prec=articulo.getElementsByClass("price").text();
				//prec = prec.replace("Con financiación","");
				prec = prec.replace("€","");
				meter.add(prec);
				//KILÓMETROS
				
				//lis = articulo.select("li:contains(Kilómetros)");
				prec=articulo.getElementsByClass("km").text();
				prec = prec.replace("km","");
//				prec=lis.select("span").text();
				meter.add(prec);
				//URL
				lis=articulo.getElementsByClass("primary-link");
				prec=lis.attr("href");
				meter.add(prec);
				//IMAGEN
				
				lis=articulo.getElementsByClass("main-photo");
				prec=lis.attr("src");
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
	public Document ObtenerHTML() {
		String url = "https://www.coches.com/coches-segunda-mano/alfa-romeo.html";
		Response response = null;
	    try {
	    	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    	System.out.println("Codigo:" + response.statusCode());
	    } catch (IOException ex) {
	    	System.out.println("Excepci�n al obtener el Status Code: " + ex.getMessage());
	    }
	    
	    
	    Document doc = null;
  	try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
					
  	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return doc;
	    
	}


	

}
