package modelo;

import java.util.HashSet;
import java.util.Stack;

import modelo.seres.Trabajador;

public class Factoria {

	private Stack<Trabajador> trabajadores;
	private int maxTrabajadores = 1000;
	private double produccionTrabajador = 1000;

	public Factoria() {
		super();
		this.trabajadores = new Stack<Trabajador>();
	}

	// la cantidad de trabajadores no pueden ser mayor a su maxTrabajadores
	public void contratarTrabajador(Trabajador trabajador) {

	}

	// Se despide una cantidad de trabajadores, y estos seran siempre los ultimos en
	// entrar
	public void despedirTrabajadores(Stack<Trabajador> listaDesempleados, int numDespedidos) {

	}

	// despide a todos los trabajadores
	public void cerraFactoria(Stack<Trabajador> listaDesempleados) {

	}

	// Este me devuelve el dinero anual que a producido , quitando los gastos de
	// mantenimiento .Vamos a establecer un coste de mantenimiento anual de las
	// factorías
	// que sera un porcentaje de su producción máxima 5%
	public double getProduccionAnual() {
		return 0;
	}

	public void eliminarTrabajador(int id) {
		for (Trabajador trabajador : trabajadores) {
			if (trabajador.getId() == id) {
				trabajadores.remove(trabajador);
			}
		}
	}

	public Stack<Trabajador> getTrabajadores() {
		return trabajadores;
	}

}
