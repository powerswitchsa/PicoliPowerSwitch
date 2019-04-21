package modelo.seres;

import modelo.Ser;

public class Jubilado extends Ser {

	public Jubilado(String nombre, int id, double ahorros) {
		super(nombre, id);
		setEdad(64);
		setNecesidadVital(182.5f);
	}

	@Override
	public void cobrar(double sueldo, double dineroEstado) {
		if (getAhorros() >= getNecesidadVital()) {
			setAhorros(getAhorros() - getNecesidadVital());
		} else {
			double cuenta = getNecesidadVital() - dineroEstado;
			if (cuenta < 0) {
				cuenta += getAhorros();
				if (cuenta < 0) {
					reducirEsperanzaVida(Math.abs(cuenta));
				}
			}
		}
	}

	@Override
	public boolean morir() {
		if (getFechaMuerte() <= getEdad()) {
			return true;
		}
		return false;
	}
}
