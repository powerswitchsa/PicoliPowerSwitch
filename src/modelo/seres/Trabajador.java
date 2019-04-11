package modelo.seres;

import modelo.Seres;

public class Trabajador extends Seres {

	public Trabajador(String nombre, int id) {
		super(nombre, id);
		setEdad(18);
		setSueldoMinimoVivir(365);
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
