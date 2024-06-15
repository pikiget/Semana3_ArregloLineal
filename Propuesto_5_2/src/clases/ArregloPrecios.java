package clases;

public class ArregloPrecios {
	double[] precio = {240.5, 350.2, 80.4, 100.3, 470.1, 60.0, 330.8, 260.6, 510.9, 200.7};
	
	public ArregloPrecios() {
		
	}
	
	public int tamaño() {
		return precio.length;
	}
	public double obtener(int i) {
		return precio[i];
	}
	public double precioPromedio() {
		double sum=0;
		for(int i=0; i<tamaño(); i++) {
			sum+=precio[i];
		}
		return sum / tamaño();
	}
	public double precioMayor() {
		double num = 0;
		for(int i=0; i<tamaño(); i++) {
			if(precio[i]>num)
				num=precio[i];
		}
		return num;
	}
	public double precioMenor() {
		double num = precioMayor();
		for(int i=0; i<tamaño(); i++) {
			if(precio[i]<num)
				num=precio[i];
		}
		return num;
	}
	
	public int cantMayoresPrecioPromedio() {
		int cant = 0;
		for(int i=0; i<tamaño(); i++) {
			if(precio[i]>=precioPromedio())
				cant++;
		}
		return cant;
	}
	
	public int cantMenoresPrecioPromedio() {
		return tamaño() - cantMayoresPrecioPromedio();
	}
	
	public int posPrimerPrecioMayorAlSegundo() {
		for(int i=0; i<tamaño(); i++) {
			if(precio[i] > precio[1])
				return i;
		}
		return -1;
	}
	public int posUltimoPrecioMenorAlPenultimo() {
		for(int i=tamaño()-1; i>=0; i--) {
			if(precio[i] > precio[2])
				return i;
		}
		return -1;
	}
	private double aleatorio(double min, double max) {
		 return (double)((max - min + 1) * Math.random()) + min;
	}
	
	public void generarPrecios() {
	
		for(int i=0; i<precio.length; i++) {
			
			precio[i]=aleatorio(99.9,999.9);
		}
	}
	
}
