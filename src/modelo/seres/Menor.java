package modelo.seres;

import modelo.Ser;
import utilesglobal.Utilies;

public class Menor extends Ser {

	public Menor(int id) {
		super(Utilies.getNombreAleatorio(), id);
		setEdad(0);
		setNecesidadVital(365);
	}
	
	
	// si no cobran lo suficiente baja la esperanza de vida
	@Override
	public void cobrar(int sueldo, double dineroEstado) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean morir() {
		// TODO Auto-generated method stub
		return false;
	}

}
