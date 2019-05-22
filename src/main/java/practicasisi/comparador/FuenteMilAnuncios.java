package practicasisi.comparador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet(
    name = "MilAnuncios",
    urlPatterns = {"/fuentemilanuncios"}
)
public class FuenteMilAnuncios extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		
		
			public Document ObtenerDoc() {
				Response response1=null;
				Document doc=null;
				String url="https://www.autocasion.com/coches-segunda-mano/alfa-romeo-ocasion";
				 try {
				    	response1 = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
				    	
				    } catch (IOException ex) {
				    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
				    }
				  
				  try {
					   doc = Jsoup.connect(url).get();
					 
				  } catch (IOException ex) {
				    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
				    }
				
				return doc;
			}
			public ArrayList<ArrayList<String>> ObtenerDatos(Document doc) {
				ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList <String>>();
				Element body = doc.body();
				Elements articulos = body.getElementsByClass("anuncio");
				
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
						meter.add(prec);
						//COMBUSTIBLE
						prec=lis.select("li:contains(Combustible)").select("span").text();
						meter.add(prec);
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
						//prec = prec.replace("Kilómetros:","");
						prec = prec.replace("km","");
						
						meter.add(prec);
						//URL
						
						
						lis=articulo.select("a");
						prec="https://www.autocasion.com"+lis.attr("href");
						meter.add(prec);
				    datos.add(meter);
				    //IMAGEN
				    lis=articulo.select("img");
				    prec="https:"+lis.attr("src");
				    meter.add(prec);
				    
				    datos.add(meter);
				}
//				articulos = body.getElementsByClass("anuncio");
//				for (Element articulo : articulos){
//					lis = articulo.select("li:contains(Kilómetros)");
//				}
				
				
				
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
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {
		  ArrayList<ArrayList<String>> datos=new ArrayList<ArrayList<String>>();
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");

	    response.getWriter().print("Hola pr�ctica de ISI!\r\n");
	    Document doc=ObtenerDoc();
	    datos=ObtenerDatos(doc);
	    for(ArrayList<String> linea : datos) {
	    	response.getWriter().print(linea+"\n");
	    }
	    //response.getWriter().print(datos);
	    //response.getWriter().print(doc);
	  }
	  
	  
	  public void Buscar(String marca, String potencia, String provincia, String fecha, String precio, String km) {
		  ArrayList<ArrayList<String>> datos=new ArrayList<ArrayList<String>>();

		  Document doc=ObtenerDoc();
		    datos=ObtenerDatos(doc);
		    for(ArrayList<String> linea : datos) {
		    	System.out.print(linea+"\n");
		    }
		}
	  
	}


