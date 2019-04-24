package modelo;

import java.util.ArrayList;
import java.util.Stack;

public class Factoria {

	private Stack<Ser> trabajadores;
	private int maxTrabajadores = 1000;
	private double produccionTrabajador = 1000;

	public Factoria() {
		super();
		this.trabajadores = new Stack<Ser>();
	}

	// la cantidad de trabajadores no pueden ser mayor a su maxTrabajadores
	public void contratarTrabajador(Ser trabajador) {

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

	// Este me devuelve el dinero anual que a producido
	public double getProduccionAnual() {
		return 0;
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
