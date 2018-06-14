package Codigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivo_Pelicula {
	public String na;
	private Pelicula pe;
	public Archivo_Pelicula(String na) {
		super();
		this.na = na;
	}
	public void Crear() throws ClassNotFoundException,IOException {
		ObjectOutputStream aPe = new ObjectOutputStream(new FileOutputStream(na));
		aPe.close();
	}	
	public void Adicionar(String[] vect, int i) throws ClassNotFoundException, IOException{
		String op;
		ObjectOutputStream aPe =null;
		try {
			if(new File(na).exists()) {
				aPe = new AddObjectOutputStream(new FileOutputStream(na,true));
			}else{
				aPe = new AddObjectOutputStream(new FileOutputStream(na,true));
			}
			pe=new Pelicula();
			pe.leer(vect,i);
			aPe.writeObject(pe);
			System.out.println("se guardo correct");
			aPe.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("fin adiciona");
		}
	}
	public Pelicula[] Listar() throws ClassNotFoundException, IOException {
		ObjectInputStream aPe = null;
		Pelicula p[]=new Pelicula[N()];
		System.out.println("------**   "+p.length);
		try {
			aPe = new ObjectInputStream(new FileInputStream(na));						
			int i=0;
			while(true) {
				pe = new Pelicula();
				pe = (Pelicula)aPe.readObject();				
				p[i]=pe;
				i++;
			}			
		}
		catch(Exception e) {
			System.out.println("fin listado2");
			
		}
		finally {
			return p;
		}
	}
	public int N() throws ClassNotFoundException, IOException {
		ObjectInputStream aPe = null;
		int i=0;
		try {
			aPe = new ObjectInputStream(new FileInputStream(na));						
			while(true) {
				pe = new Pelicula();
				pe = (Pelicula)aPe.readObject();
				i++;				
			}
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("fin listado1");
			
		}
		finally{
			return i;
		}
		
	}
}
