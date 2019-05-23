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
		Elements articulos = body.select("article.elemento-segunda-mano");
		//mt-Card-hover  mt-Card--topAd
		String prec="";
		
		for (Element articulo : articulos){
			
				Elements lis = articulo.getElementsByClass("nombre-vehiculo");
				ArrayList<String> meter= new ArrayList<String>();
				//meter.add(articulo.select("h2").text());
				//prec=lis.select("span:contains(cv)").text();
				//MARCA Y MODELO
				
				meter.add(lis.select("a").text());
				
				//POTENCIA
				
				lis=articulo.select("li");
				prec=lis.select(":contains(cv)").text();
				prec = prec.replace("CV","");
				meter.add(prec);
				//COMBUSTIBLE
				Element li=articulo.select("ul").get(0);
				meter.add(li.child(1).text());
				//ZONA GEOGRAFICA
				prec=articulo.getElementsByClass("lugar").text();
				int inicio=prec.indexOf("(");
				//int fin=prec.indexOf(")");
				prec=prec.substring(inicio+1);
				prec=prec.replace(")","");
				meter.add(prec);
				//FECHA MATRICULACION
				li=articulo.select("ul").get(0);
				meter.add(li.child(0).text());
//				meter.add(articulo.getElementsByClass("year").text());
				//PRECIO
				
				prec=articulo.select("strong").text();
				//prec = prec.replace("Con financiación","");
				prec = prec.replace("€","");
				meter.add(prec);
				//KILÓMETROS
				lis=articulo.select("li");
				prec=lis.select(":contains(Km)").text();
				prec = prec.replace("Km","");
				meter.add(prec);
				
				//URL
				lis=articulo.getElementsByClass("datos");
				lis=lis.select("a");
				prec=lis.attr("href");
				meter.add(prec);
				//IMAGEN
				lis=articulo.getElementsByClass("imagen");
				lis=lis.select("img");
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
		String url = "https://www.motor.es/coches-segunda-mano/?marca=6";
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
