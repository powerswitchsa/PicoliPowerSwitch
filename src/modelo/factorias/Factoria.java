package modelo.factorias;

import java.util.Stack;

import modelo.seres.Trabajador;

public class Factoria {

	private boolean open;
	private Stack<Trabajador> trabajadores;
	private int maxTrabajadores;
	private long produccionTrabajador;

	public Factoria(TipoFactoria densidad, boolean open) {
		super();
		this.open = open;
		this.trabajadores = new Stack<Trabajador>();
		this.maxTrabajadores = densidad.getNumTrabajadores();
		this.produccionTrabajador = 1000;
	}

	// la cantidad de trabajadores no pueden ser mayor a su numMaxTrabajadores
	public void contratarTrabajador(Trabajador trabajador) {

	}

	// Se despide al ultimo que entra
	public void despedirTrabajador(Stack<Trabajador> listaDesempleados) {

	}

	// despide a todos los trabajadores, y cierra empresa
	public void cerraFactoria(Stack<Trabajador> listaDesempleados) {

	}

}
