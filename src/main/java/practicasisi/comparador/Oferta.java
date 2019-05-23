package practicasisi.comparador;

public class Oferta {
	private String marca;
	private int potencia;
	private String provincia;
	private int fecha;
	private int precio;
	private int km;
	private String combustible;
	
	public Oferta() {
		
	}
	
	public Oferta(String marca, int potencia, String provincia, int fecha, int precio, int km, String combustible) {
		this.marca = marca;
		this.potencia = potencia;
		this.provincia = provincia;
		this.fecha = fecha;
		this.precio = precio;
		this.km = km;
		this.combustible = combustible;
	}
	
	
	
	  public String getMarca() {
	    return marca;
	  }
	  
	  public void setMarca(String marca) {
	    this.marca = marca;
	  }
	  
	  public int getPotencia() {
	    return potencia;
	  }
 
	  public void setPotencia(int potencia) {
	    this.potencia = potencia;
	  }
	
	  public String getProvincia() {
	    return provincia;
	  }
 
	  public void setProvincia(String provincia) {
	    this.provincia = provincia;
	  }
	  
	  public int getFecha() {
	    return fecha;
	  }
 
	  public void setFecha(int fecha) {
	    this.fecha = fecha;
	  }
	  
	  public int getPrecio() {
	    return precio;
	  }
 
	  public void setPrecio(int precio) {
	    this.precio = precio;
	  }
	  
	  public int getKm() {
	    return km;
	  }
 
	  public void setKm(int km) {
	    this.km = km;
	  }
	
	  public String getCombustible() {
	    return combustible;
	  }
 
	  public void setCombustible(String combustible) {
	    this.combustible = combustible;
	  }
}
