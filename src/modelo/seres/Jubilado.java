package modelo.seres;

import modelo.Seres;

public class Jubilado extends Seres {

	public Jubilado(String nombre, int id) {
		super(nombre, id);
		setEdad(64);
		setSueldoMinimoVivir(182.5f);
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
