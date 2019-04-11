package modelo.seres;

import modelo.Seres;

public class Menor extends Seres {

	public Menor(String nombre, int id) {
		super(nombre, id);
		setEdad(0);
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
