package clases;

public class ArregloSueldos {
	double[] sueldo = {2400.5, 800.4, 1500.2, 1000.3, 4700.1, 600.0, 3300.8, 2600.6, 5100.9, 2000.7};
	
	public ArregloSueldos() {
		
	}
	
	public int tamaño() {
		return sueldo.length;
	}
	
	public double obtener(int p) {
		return sueldo[p];
	}
	
	public double sueldoPromedio() {
		double acu=0;
		for (int i=0; i<tamaño(); i++) {
			acu+=sueldo[i];
		}
		
		return acu/tamaño();
		
	}
	public double sueldoMayor() {
		double myo=0;
		for (int i=0; i<tamaño(); i++) {
			if(sueldo[i]>myo)
				myo=sueldo[i];
		}
		return myo;
	}
	public double sueldoMenor() {
		double mnr=sueldoMayor();
		
		for (int i=0; i<tamaño(); i++) {
			if(sueldo[i]<mnr)
				mnr=sueldo[i];
		}
		return mnr;
	}
	public int cantMayoresSueldoPromedio() {
		int cont=0;
		
		for (int i=0; i<tamaño(); i++) {
			if(sueldo[i]>sueldoPromedio())
				cont++;
		}
		return cont;
	}
	
	public int cantMenoresSueldoPromedio() {
		return tamaño() - cantMayoresSueldoPromedio();
	}
	
	public int posSegundoSueldoMayorAlMinimo() {
		int cant=0;
		for (int i=0; i<tamaño(); i++) {
			if(sueldo[i]> 850.0)
				cant++;
			if(cant == 2)
				return i;
		}
		return -1;
	}
	
	public int posUltimoSueldoMenorAlMinimo() {
		for(int i=tamaño(); i>=0; i++) {
			if(sueldo[i]<850.0)
				return i;
		}
		return -1;
	}
	
	private double aleatorio(double min, double max) {
		return(double)((max-min+1)* Math.random()) + min;
	}
	
	public void generarSueldo() {
		for(int i=0; i<tamaño(); i++) {
			sueldo[i]=aleatorio(i, i);
		}
	}
	
	
	
}
