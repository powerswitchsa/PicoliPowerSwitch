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
	// importante ya esta creado el metodo que le reduce la vida, ha este le entra
	// lo que le falta para tener el max NV
	@Override
	public void cobrar(double sueldo, double dineroEstado) {
		// TODO Auto-generated method stub

	}

	// true si ha muerto
	@Override
	public boolean morir() {
		// TODO Auto-generated method stub
		return false;
	}

}
