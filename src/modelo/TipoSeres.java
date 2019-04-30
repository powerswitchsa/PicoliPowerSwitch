package modelo;

public enum TipoSeres {

	menor(365, 365, "menor"), desempleado(182.5, 365, "desempleado"), trabajador(730, 365, "trabajador"),
	jubilado(91.25, 182.5, "jubilado");

	private double sueldo;
	private double NV;
	private String tipo;

	private TipoSeres(double sueldo, double nV, String tipo) {
		this.sueldo = sueldo;
		NV = nV;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public double getNV() {
		return NV;
	}

}
