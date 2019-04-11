package modelo.factorias;

public enum Densidad {

	pequeña(100), mediana(400), grande(1000);

	private int numTrabajadores;

	private Densidad(int numTrabajadores) {
		this.numTrabajadores = numTrabajadores;
	}

	public int getNumTrabajadores() {
		return numTrabajadores;
	}

}
