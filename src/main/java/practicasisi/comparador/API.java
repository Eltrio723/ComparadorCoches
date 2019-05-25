package practicasisi.comparador;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map;

import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class API {
	String url="";
	
	public String ObtenerDatosParaJSON(String marca) 
			throws IOException {
		//ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList <String>>();
		String datos="";
		if(marca.equals("Audi")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[audi]=";
		}else if(marca.equals("BMW")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[bmw]=";
		}else if(marca.equals("Ford")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[ford]=";
		}else if(marca.equals("Honda")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[honda]=";
		}else if(marca.equals("Mercedes")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[mercedes-benz]=";
		}else if(marca.equals("Mini")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[mini]=";
		}else if(marca.equals("Peugeot")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[peugeot]=";
		}else if(marca.equals("Seat")) {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[seat]=";
		}																	//  ["+marca+"]
			
			
			URL obj = new URL(url);
			URLConnection con = obj.openConnection();
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 String linea;
	            while ((linea = in.readLine()) != null) {
	                datos=datos+linea;
	                //System.out.print(datos);
	            }
	    
			  
			return datos;
		}
	
	public JsonObject CambioJSON(String datos) 
			{
		 //Object obj = new JSONParser().parse(datos); 
//		 JSONParser obj = new JSONParser();
		JsonObject jsonObject = new Gson().fromJson(datos, JsonObject.class);
	        return jsonObject;
	}
	public ArrayList<ArrayList<String>> obtenerDatos(JsonObject json){
		
		ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList<String>>();
		ArrayList<String> meter= new ArrayList<String>();
		
		JsonObject objeto=json.getAsJsonObject("occasions");
		System.out.print(json.get("occasions").getAsString());
		String prec="";
		int posicion;
		JsonObject elemento2=new JsonObject();
		int num_ofertas= json.get("totalCount").getAsInt();
		
		for(int i=0;i<num_ofertas;i++) {
			
			JsonObject elemento1=objeto.getAsJsonObject(Integer.toString(i));
			//PARA MARCA Y MODELO
			prec=elemento1.get("make").getAsString();
			prec+=elemento1.get("model").getAsString();
			prec+=elemento1.get("type").getAsString();
			System.out.print(prec);
			meter.add(prec);
			//POTENCIA
			prec=elemento1.get("type").getAsString();
			posicion=prec.lastIndexOf(" ");
			prec=prec.substring(posicion+1);
			meter.add(prec);
			//COMBUSTIBLE
			prec=elemento1.get("fuel").getAsString();
			if(prec.equals("gasoline")) {
				meter.add("gasolina");
			}else if(prec.equals("diesel")) {
				meter.add("diesel");
			}else {
				meter.add("electrico");
			}
			//ZONA GEOGRAFICA
			prec=elemento1.get("retailLocationCode").getAsString();
			meter.add(prec);
		
			//FECHA MATRICULACION
			prec=Integer.toString(elemento1.get("yearOfConstruction").getAsInt());
			meter.add(prec);
		
			//PRECIO
			elemento2=objeto.getAsJsonObject("salePrice");
			prec=Integer.toString(elemento2.get("amount").getAsInt());
			meter.add(prec);
		
			//KILÓMETROS
			elemento2=objeto.getAsJsonObject("mileage");
			prec=Integer.toString(elemento2.get("amount").getAsInt());
			meter.add(prec);
		
			//URL
			prec="https://www.carnext.com/es-es/coches/";
			prec+=elemento1.get("make").getAsString()+"/";
			prec+=elemento1.get("model").getAsString()+"/";
			prec+=elemento1.get("id").getAsString()+"/";
			meter.add(prec);
		
			//IMAGEN
			elemento2=objeto.getAsJsonObject("image");
			prec=elemento2.get("urlTemplate").getAsString();
			prec=prec.replace("{size}","400");
			prec=prec.replace("{dimension}","width");
			meter.add(prec);
		
		datos.add(meter);
		}
		
		return datos;
	}
	public Coleccion Buscar(ArrayList<ArrayList<String>> datos) {
		  

		  
		    
		    Coleccion coleccion = new Coleccion();
		    //System.out.println("hola");
		    for(ArrayList<String> linea : datos) {
		    	
		    	System.out.println(linea.get(0));//MARCA Y MODELO
		    	System.out.println(linea.get(1));//PTENCIA
		    	System.out.println(linea.get(2));//COMBUSTIBLE
		    	System.out.println(linea.get(3));//PROVINCIA
		    	System.out.println(linea.get(4));//AÑO
		    	System.out.println(linea.get(5));//PRECIO
		    	System.out.println(linea.get(6));//KM
		    	System.out.println(linea.get(7));//LINK
		    	System.out.println(linea.get(8));//IMAGEN
		    	
		    	if(linea.get(1).trim().equals("")) {
		    		linea.set(1, "0");
		    	}
		    	if(linea.get(4).trim().equals("")) {
		    		linea.set(4, "0");
		    	}
		    	if(linea.get(5).trim().equals("")) {
		    		linea.set(5, "0");
		    	}
		    	if(linea.get(6).trim().equals("")) {
		    		linea.set(6, "0");
		    	}
		    	
		    	Oferta o = new Oferta(linea.get(0), Integer.parseInt(linea.get(1)), linea.get(2), linea.get(3), Integer.parseInt(linea.get(4)), Integer.parseInt(linea.get(5)),Integer.parseInt(linea.get(6)), linea.get(7),linea.get(8));
		    	//System.out.println(linea.get(0));
		    	coleccion.pushOferta(o);
		    }
		    return coleccion;
		}
}
