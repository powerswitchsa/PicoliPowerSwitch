package modelo.factorias;

import java.util.HashSet;

import modelo.seres.Trabajador;

public class Factoria {

	private HashSet<Trabajador> trabajadores;
	private int numMaxTrabajadores;
	private long beneficiosTrabajador;

	public Factoria(Densidad densidad) {
		super();
		this.trabajadores = new HashSet<>(densidad.getNumTrabajadores());
//		this.numMaxTrabajadores = densidad.getNumTrabajadores();
		this.beneficiosTrabajador = 1000;
	}

	public void contratarTrabajador(Trabajador trabajador) {

	}

	public void despedirTrabajador() {

	}
	
	

}
