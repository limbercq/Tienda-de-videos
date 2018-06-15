package Codigo;

public class Pelicula implements java.io.Serializable {
	private String cod;
	private String nombre;
	private String duracion;
	private String idioma;
	private String fechaEstr;
	private int tipo;
	private String precio;
	private String nroCop;
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getFechaEstr() {
		return fechaEstr;
	}
	public void setFechaEstr(String fechaEstr) {
		this.fechaEstr = fechaEstr;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getNroCop() {
		return nroCop;
	}
	public void setNroCop(String nroCop) {
		this.nroCop = nroCop;
	}
	public void leer(String[] vect, int i) {
		try {
			this.nombre = vect[0];
			this.idioma= vect[1];
			this.fechaEstr = vect[2];
			this.cod = vect[3];
			this.precio = vect[4];
			this.duracion = vect[5];
			this.nroCop = vect[6];
			this.tipo = i;
		}
		catch(Exception e) {
			System.out.println("------------------------sff");
			System.out.println(e);
		}
		
	}
	public void mostrar() {
		System.out.println("cod "+this.nombre);
		
	}
	
	
}
