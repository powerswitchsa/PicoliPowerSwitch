package modelo.seres;

import modelo.Ser;
import utilesglobal.Utilies;

public class Menor extends Ser {

	public Menor(int id) {
		super(Utilies.getNombreAleatorio(), id);
		setEdad(0);
		setNecesidadVital(365);
	}

	@Override
	public void cobrar(int sueldo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean morir() {
		// TODO Auto-generated method stub
		return false;
	}

}
