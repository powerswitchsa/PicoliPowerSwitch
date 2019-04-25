package modelo;

public class CapitalEstado {

	private double dineroEstado;

	public CapitalEstado(double dineroEstado) {
		super();
		this.dineroEstado = dineroEstado;
	}

	public double obtenerSueldo(int numSeres, double sueldo) {
		double dineroNecesario = numSeres * sueldo;
		if (dineroNecesario > this.dineroEstado) {
			sueldo = this.dineroEstado / numSeres;
			this.dineroEstado -= dineroNecesario;
			return sueldo;
		} else {
			this.dineroEstado -= dineroNecesario;
			return sueldo;
		}
	}

	public double obtenerSubsidioJubilado(double subsidioTotal) {
		return 0; // % que hay que aplicar al sueldo
	}

	public double getDineroEstado() {
		return dineroEstado;
	}

	public void setDineroEstado(double dineroEstado) {
		this.dineroEstado = dineroEstado;
	}

	public void sumarDineroEstado(double dinero) {
		this.dineroEstado += dinero;
	}

}
