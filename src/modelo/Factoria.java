package modelo;

import java.util.ArrayList;
import java.util.Stack;

public class Factoria {

	private Stack<Ser> trabajadores;
	private double produccionTrabajador = 1000;

	public Factoria() {
		super();
		this.trabajadores = new Stack<Ser>();
	}

	public void contratarTrabajador(Ser trabajador) {
		this.trabajadores.add(trabajador);
	}

	// Se despide una cantidad de trabajadores, y estos seran siempre los ultimos en
	// entrar , los despedidos son metidos en una lista y retornados
	public ArrayList<Ser> despedirTrabajadores(ArrayList<Ser> listaDesempleados, int numDespedidos) {
		return null;
	}

	// despide a todos los trabajadores
	public ArrayList<Ser> cerraFactoria(Stack<Ser> listaDesempleados) {
		return null;
	}

	public double getProduccionAnual() {
		return this.produccionTrabajador * this.getTrabajadores().size();
	}

	public void eliminarTrabajador(int id) {
		for (Ser trabajador : trabajadores) {
			if (trabajador.getId() == id) {
				trabajadores.remove(trabajador);
			}
		}
	}

	public Stack<Ser> getTrabajadores() {
		return trabajadores;
	}

}
