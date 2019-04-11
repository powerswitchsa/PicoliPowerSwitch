package modelo.seres;

import modelo.Seres;

public class Menor extends Seres {

	public Menor(String nombre) {
		super(nombre);
		setEdad(0);
		setSueldoMinimoVivir(365);
	}

	@Override
	public void cobrar(int sueldo) {
		// TODO Auto-generated method stub
		
	}

}
