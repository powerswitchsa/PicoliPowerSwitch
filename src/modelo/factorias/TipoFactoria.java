package modelo.factorias;

public enum TipoFactoria {

	pequeña(100, 15), mediana(400, 10), grande(1000, 5);

	private int numTrabajadores;
	private int costeMantenimiento;

	private TipoFactoria(int numTrabajadores, int costeMantenimiento) {
		this.numTrabajadores = numTrabajadores;
		this.costeMantenimiento = costeMantenimiento;
	}

	public int getNumTrabajadores() {
		return numTrabajadores;
	}

	public int getCosteMantenimiento() {
		return costeMantenimiento;
	}

}
