package modelo;

public class CapitalEstado {

	private double dineroEstado;

	public CapitalEstado(double dineroEstado) {
		super();
		this.dineroEstado = dineroEstado;
	}

	public double obtenerSueldo(double numMenores, double sueldo) {
		double dineroNecesario = numMenores * sueldo;
		if (dineroNecesario <= this.dineroEstado) {
			this.dineroEstado -= dineroNecesario;
			return sueldo;
		}
		double repartido = 0;
		if (dineroEstado >= 0) {
			repartido = this.dineroEstado / numMenores;
			this.dineroEstado = 0;
		}
		return repartido;
	}

	public double obtenerSubsidioJubilado(double subsidioTotal) {
		return ((this.dineroEstado * 100) / subsidioTotal) / 100;
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
