package practicasisi.comparador;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

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
																						//  ["+marca+"]
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels[jeep]=";
			
			URL obj = new URL(url);
			URLConnection con = obj.openConnection();
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 String linea;
	            while ((linea = in.readLine()) != null) {
	                datos=datos+linea;
	                System.out.print(datos);
	            }
	       


			 
			return datos;
		}
	
	public JSONObject CambioJSON(String datos) throws FileNotFoundException, IOException, ParseException {
		 Object obj = new JSONParser().parse(datos); 
         
	       
	        JSONObject jo = (JSONObject) obj; 
	        return jo;
	}
}
