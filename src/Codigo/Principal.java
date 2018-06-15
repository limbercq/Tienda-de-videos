package Codigo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args)throws ClassNotFoundException, IOException {
		Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
		//a.Crear();
		String f[]=new String[7];
		leer(f);
		/*f[0]="s";
		a.Adicionar(f, 4);*/
		//a.Listar();
		//System.out.println((int) (Math.random()*30));
	
	}

	private static void leer(String[] f) throws ClassNotFoundException, IOException {
		Archivo_Pelicula a =new Archivo_Pelicula("Pelicula.dat");
		Scanner al=new Scanner(System.in);
		for(int i=0;i<108;i++) {
			System.out.println(i);
			for(int j=0;j<7;j++) {
				f[j]=al.next();
			}
			a.Adicionar(f, al.nextInt());
		}
		
	}

}
