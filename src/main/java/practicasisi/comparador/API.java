package practicasisi.comparador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class API {
	String url="";
	
	public String ObtenerDatosParaJSON(String marca,String potencia,String combustible,String provincia,String fecha,String precio,String km) 
			throws IOException {
		//ArrayList<ArrayList<String>> datos= new ArrayList<ArrayList <String>>();
		String datos="";
		try {
			url="https://www.carnext.com/api2/occasions/cars?locale=es-es&size=17&makeModels["+marca+"]=";
			
			URL obj = new URL(url);
			URLConnection con = obj.openConnection();
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 String linea;
	            while ((linea = in.readLine()) != null) {
	                datos=datos+linea;
	                System.out.print(datos);
	            }
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }


			 
			return datos;
		}
}
