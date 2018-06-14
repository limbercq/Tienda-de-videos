package Codigo;

import java.io.IOException;

public class Principal {

	public static void main(String[] args)throws ClassNotFoundException, IOException {
		Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
		//a.Crear();
		/*String f[]=new String[7];
		f[0]="s";
		a.Adicionar(f, 4);*/
		a.Listar();
	}

}
