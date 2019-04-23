package modelo;

public enum TipoSeres {

	menor(365, 365), desempleado(182.5, 365), trabajador(730, 365), jubilado(182.5, 182.5);

	private double sueldo;
	private double NV;

	private TipoSeres(double sueldo, double nV) {
		this.sueldo = sueldo;
		NV = nV;
	}

	public double getSueldo() {
		return sueldo;
	}

	public double getNV() {
		return NV;
	}

}
