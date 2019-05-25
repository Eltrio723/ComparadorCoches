package practicasisi.comparador;

public class Oferta implements Comparable<Oferta> {
	private String marca;
	private int potencia;
	private String combustible;
	private String provincia;
	private int fecha;
	private int precio;
	private int km;
	private String link;
	private String imagen;
	private int ponderacion;
	
	public Oferta() {
		
	}

	public Oferta(String marca, int potencia,String combustible, String provincia, int fecha, int precio, int km, String link,String imagen) {
		this.marca = marca;
		this.potencia = potencia;
		this.combustible = combustible;
		this.provincia = provincia;
		this.fecha = fecha;
		this.precio = precio;
		this.km = km;
		this.link=link;
		this.imagen=imagen;
		
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
	  
	  public String getCombustible() {
		    return combustible;
	  }
	 
	  public void setCombustible(String combustible) {
		    this.combustible = combustible;
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
	  
	  public String getLink() {
		    return link;
	  }
	 
	  public void setLink(String link) {
		    this.link = link;
	  }
	  public String getImagen() {
		    return imagen;
	  }
	 
	  public void setImagen(String imagen) {
		    this.imagen = imagen;
	  }
	  
	  public void ponderar(int potencia, String combustible, String provincia, int fecha, int precio, int km) {
		  
		  
		  //TODO
		  
		  
		  
	  }

	@Override
	public int compareTo(Oferta o) {
		return o.ponderacion - this.ponderacion;
	}
	  


	  
	  
}
