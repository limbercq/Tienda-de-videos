package Codigo;

public class Pelicula {
	protected int cod;
	protected String nombre;
	protected double duracion;
	protected String idioma;
	protected String fechaEstr;
	protected int tipo;
	protected double precio;
	protected int nroCop;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getNroCop() {
		return nroCop;
	}
	public void setNroCop(int nroCop) {
		this.nroCop = nroCop;
	}
	
	
}
