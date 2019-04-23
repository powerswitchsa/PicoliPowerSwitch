package modelo.seres;

import modelo.CapitalEstado;
import modelo.Ser;
import utilesglobal.Utilies;

public class Menor extends Ser {

	public Menor(int id) {
		super(Utilies.getNombreAleatorio(), id);
		setEdad(0);
		setNecesidadVital(365);
	}

	@Override
	public void cobrar(double sueldo, CapitalEstado capitalEstado) {
		if (sueldo < getNecesidadVital()) {
			reducirEsperanzaVida(getNecesidadVital() - sueldo);
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
