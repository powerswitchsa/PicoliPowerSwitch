package modelo.seres;

import modelo.CapitalEstado;
import modelo.Ser;

public class Jubilado extends Ser {

	public Jubilado(String nombre, int id, double ahorros) {
		super(nombre, id);
		setEdad(64);
		setNecesidadVital(182.5f);
	}

	@Override
	public void cobrar(double sueldo, CapitalEstado capitalEstado) {
		if (getAhorros() >= getNecesidadVital()) {
			setAhorros(getAhorros() - getNecesidadVital());
			capitalEstado.sumarDineroEstado(sueldo);
		} else {
			double cuenta = getNecesidadVital() - sueldo;
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
