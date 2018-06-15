package Codigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivo_Promo {
	public String na;
	private Promociones pro;
	public Archivo_Promo(String na) {
		super();
		this.na = na;
	}
	public void Crear() throws ClassNotFoundException,IOException {
		ObjectOutputStream aPe = new ObjectOutputStream(new FileOutputStream(na));
		aPe.close();
	}	
	public void Adicionar(Pelicula[] vect) throws ClassNotFoundException, IOException{
		Crear();	
		ObjectOutputStream aPe =null;
		try {
			if(new File(na).exists()) {
				aPe = new AddObjectOutputStream(new FileOutputStream(na,true));
			}else{
				aPe = new AddObjectOutputStream(new FileOutputStream(na,true));
			}
			pro=new Promociones();
			pro.leer(vect);
			aPe.writeObject(pro);
			System.out.println("*se guardo correct Promo ");
			aPe.close();
		}
		catch(Exception e) {			
			System.out.println("fin adiciona Promo");
		}
	}
	public Promociones  Listar() throws ClassNotFoundException, IOException {
		ObjectInputStream aPe = null;
		Promociones p=new Promociones();		
		try {
			aPe = new ObjectInputStream(new FileInputStream(na));
			while(true) {				
				pro = new Promociones();
				pro = (Promociones)aPe.readObject();
				p=pro;												
			}			
		} 
		catch(Exception e) {
			System.out.println("fin listadoPromo");
			
		}
		finally {
			return p;
		}
	}	
}
