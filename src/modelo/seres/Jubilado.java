package modelo.seres;

import modelo.Ser;

public class Jubilado extends Ser {

	public Jubilado(String nombre, int id) {
		super(nombre, id);
		setEdad(64);
		setNecesidadVital(182.5f);
	}

//	Debe mantenerse gastando los ahorros conseguidos durante su vida laboral. Si el jubilado 
//	gasta sus ahorros pero sigue vivo el estado se encarga de pagar la NV al jubilado. 
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
