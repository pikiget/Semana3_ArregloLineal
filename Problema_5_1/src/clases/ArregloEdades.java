package clases;

public class ArregloEdades {
	int[] edad = {27, 22, 13, 12, 25, 11, 29, 70, 15, 21};
	
	public ArregloEdades(){
		
	}
	
	public int getTamaño() {
		return edad.length;
	}
	public int getObtener(int p) {
		return edad[p];
	}
	public int gerPromedio() {
		int suma=0;
		for(int i=0; i<getTamaño(); i++) {
			suma+=edad[i];
		}
		
		return suma / getTamaño();
	}
	public int edadMayor() {
		int mayor=0;
		for(int i=0; i<getTamaño(); i++) {
			if(edad[i]>mayor)
				mayor=edad[i];
		}
		return mayor;
	}
	
	public int edadMenor() {
		int menor=edadMayor();
		for (int i=0; i<getTamaño(); i++) {
			if(edad[i]<menor)
				menor=edad[i];
		}
		return menor;
	}
	
	public int cantidadMayoresEdad() {
		int contador=0;
		for(int i=0; i<getTamaño(); i++) {
			if(edad[i]>=18)
				contador++;
		}
		
		return contador;
	}
	
	public int cantidadMenoresEdad() {
		return getTamaño()-cantidadMayoresEdad();
	}
	
	public int posPrimeraEdadAdolescente() {
		for (int i=0; i<getTamaño(); i++) {
			if(edad[i]>=12 && edad[i]<20) 
				return i;
		}
		return -1;
	}
	
	public int posUltimaEdadAdolescente() {
		for (int i=getTamaño()-1; i>=0; i--) {
			if(edad[i]>=12 && edad[i]<20) 
				return i;
		}
		return -1;
	}
	
	private int aleatorio(int min, int max) {
		 return (int)((max - min + 1) * Math.random()) + min;
	}
	
	public void generarEdades() {
		for(int i=0; i<edad.length; i++)
			edad[i]=aleatorio(10, 90);
	}
}
