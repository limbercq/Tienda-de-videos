package Codigo;

public class Promociones implements java.io.Serializable {
	private Pelicula prom1 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom2 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom3 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom4 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom5 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom6 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom7 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom8 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom9 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom10 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom11 []= new Pelicula[(int)( Math.random()*6)];
	private Pelicula prom12 []= new Pelicula[(int)( Math.random()*6)];

	

	public void leer(Pelicula[] vect) {
		for(int i=0;i<13;i++) {						
			switch(i) {
			case 1: prom1=generar(vect,0,prom1);
			break;
			case 2: prom2= generar(vect,0,prom2);
			break;
			case 3: prom3= generar(vect,0,prom3);
			break;
			case 4: prom4= generar(vect,1,prom4);
			break;
			case 5: prom5= generar(vect, 0,prom5);
			break;
			case 6: prom6=generar(vect,0,prom6);
			break;
			case 7: prom7=generar(vect,0,prom7);
			break;
			case 8: prom8=generar(vect,0,prom8);
			break;
			case 9: prom9=generar(vect,6,prom9);
			break;
			case 10: prom10=generar(vect,0,prom10);
			break;
			case 11: prom11=generar(vect, 4,prom11);
			break;
			case 12: prom12=generar(vect,2,prom12);
			break;			
			}
			
		}
		
	}
	private Pelicula[] generar(Pelicula[] vect, int x, Pelicula[] z) {
		Pelicula p[]=new Pelicula[z.length];
				
		if(x==0) {
			for(int i=0;i<p.length;i++) {
				int j;
				do {
					j=(int) (Math.random()*vect.length);
					
				}while(!validar (p,vect[j],i));
				p[i]=vect[j];
			}
		}else {
			for(int i=0;i<p.length;i++) {
				int j;
				do {
					j=(int) (Math.random()*vect.length);
					
				}while(!(vect[j].getTipo()==x & validar (p,vect[j],i)));
				p[i]=vect[j];
			}
		}
		return p;
		
		
	}

	public Pelicula[] getProm1() {
		return prom1;
	}

	public void setProm1(Pelicula[] prom1) {
		this.prom1 = prom1;
	}

	public Pelicula[] getProm2() {
		return prom2;
	}

	public void setProm2(Pelicula[] prom2) {
		this.prom2 = prom2;
	}

	public Pelicula[] getProm3() {
		return prom3;
	}

	public void setProm3(Pelicula[] prom3) {
		this.prom3 = prom3;
	}

	public Pelicula[] getProm4() {
		return prom4;
	}

	public void setProm4(Pelicula[] prom4) {
		this.prom4 = prom4;
	}

	public Pelicula[] getProm5() {
		return prom5;
	}

	public void setProm5(Pelicula[] prom5) {
		this.prom5 = prom5;
	}

	public Pelicula[] getProm6() {
		return prom6;
	}

	public void setProm6(Pelicula[] prom6) {
		this.prom6 = prom6;
	}

	public Pelicula[] getProm7() {
		return prom7;
	}

	public void setProm7(Pelicula[] prom7) {
		this.prom7 = prom7;
	}

	public Pelicula[] getProm8() {
		return prom8;
	}

	public void setProm8(Pelicula[] prom8) {
		this.prom8 = prom8;
	}

	public Pelicula[] getProm9() {
		return prom9;
	}

	public void setProm9(Pelicula[] prom9) {
		this.prom9 = prom9;
	}

	public Pelicula[] getProm10() {
		return prom10;
	}

	public void setProm10(Pelicula[] prom10) {
		this.prom10 = prom10;
	}

	public Pelicula[] getProm11() {
		return prom11;
	}

	public void setProm11(Pelicula[] prom11) {
		this.prom11 = prom11;
	}

	public Pelicula[] getProm12() {
		return prom12;
	}

	public void setProm12(Pelicula[] prom12) {
		this.prom12 = prom12;
	}



	private boolean validar(Pelicula[] p, Pelicula vect, int x) {
		boolean sw=true;
		int i=0;
		while(i<x & sw==true){
			if(vect.getCod().equals(p[i].getCod()))
				sw=false;
			i++;
		}
		return sw;
	}

	
	
	
}
