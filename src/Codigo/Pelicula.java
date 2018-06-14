package Codigo;

public class Pelicula implements java.io.Serializable {
	protected String cod;
	protected String nombre;
	protected String duracion;
	protected String idioma;
	protected String fechaEstr;
	protected int tipo;
	protected String precio;
	protected int nroCop;
	
	
	public void leer(String[] vect, int i) {
		try {
			this.nombre = vect[0];
			this.idioma= vect[1];
			this.fechaEstr = vect[2];
			this.cod = vect[3];
			this.precio = vect[4];
			this.duracion = vect[5];
			//this.nroCop = Integer.parseInt(vect[6]);
			this.tipo = i;
		}
		catch(Exception e) {
			System.out.println("sff");
			System.out.println(e);
		}
		
	}
	public void mostrar() {
		System.out.println("cod "+this.nombre);
		
	}
	
	
}
