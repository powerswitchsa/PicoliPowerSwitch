package modelo.seres;

import modelo.Ser;

public class Jubilado extends Ser {

	public Jubilado(String nombre, int id, double ahorros) {
		super(nombre, id);
		setEdad(64);
		setNecesidadVital(182.5f);
	}

//	Debe mantenerse gastando los ahorros conseguidos durante su vida laboral. Si el jubilado 
//	gasta sus ahorros pero sigue vivo el estado se encarga de pagar la NV al jubilado. 
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