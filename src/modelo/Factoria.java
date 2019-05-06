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

	public void setContratarTrabajador(Ser trabajador) {
		this.trabajadores.add(trabajador);
	}

	public double getProduccionAnual() {
		return this.produccionTrabajador * this.getTrabajadores().size();
	}

	public void setEliminarTrabajador(int id) {
		for (Ser trabajador : trabajadores) {
			if (trabajador.getId() == id) {
				trabajadores.remove(trabajador);
			}
		}
	}

	public ArrayList<Integer> setDespedirTrabajadores(int numDespedidos) {
		int contador = 0;
		ArrayList<Integer> listaId = new ArrayList<Integer>();
		do {
			listaId.add(this.trabajadores.pop().getId());
			contador++;
		} while (contador < numDespedidos);
		return listaId;
	}

	public int getPuestoVacantes() {
		return 1000 - this.trabajadores.size();
	}

	public Stack<Ser> getTrabajadores() {
		return trabajadores;
	}

}
