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
			double cuenta = this.dineroEstado / numSeres;
			this.dineroEstado -= dineroNecesario;
			return cuenta;
		} else {
			this.dineroEstado -= dineroNecesario;
			double cuenta = sueldo;
			return cuenta;
		}
	}

	public double getSubsidioMenor(double numMenores) {
		double dineroNecesario = numMenores * 365;
		if (dineroNecesario < this.dineroEstado) {
			this.dineroEstado -= dineroNecesario;
			return 365;
		}
		double repartido = 0;
		if (dineroEstado > 0) {
			repartido = this.dineroEstado / numMenores;
		}
		return repartido;
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
