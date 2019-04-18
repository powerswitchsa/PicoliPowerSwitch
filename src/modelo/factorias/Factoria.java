package modelo.factorias;

import java.util.HashSet;
import java.util.Stack;

import modelo.seres.Trabajador;

public class Factoria {

//	Todos los trabajadores producen 1000$ 
//	pequeña (100 trabajadores max) (100 X 1000 = 100.000$)
//	media (400 trabajadores max)  (400 X 1000 = 400.000$)
//	grande (1000 trabajadores max) (1000 X 1000 = 1.000.000$)

	private boolean open;
	private Stack<Trabajador> trabajadores;
	private int maxTrabajadores;
	private int porcentajeGastosFactoria;
	private long produccionTrabajador;

	public Factoria(TipoFactoria densidad, boolean open) {
		super();
		this.open = open;
		this.trabajadores = new Stack<Trabajador>();
		this.maxTrabajadores = densidad.getNumTrabajadores();
		this.porcentajeGastosFactoria = densidad.getCosteMantenimiento();
		this.produccionTrabajador = 1000;
	}

	// la cantidad de trabajadores no pueden ser mayor a su numMaxTrabajadores
	public void contratarTrabajador(Trabajador trabajador) {

	}

	// Se despide una cantidad de trabajadores, y estos seran siempre los ultimos en entrar
	public void despedirTrabajador(Stack<Trabajador> listaDesempleados, int numDespedidos) {

	}

	// despide a todos los trabajadores, y cierra empresa
	public void cerraFactoria(Stack<Trabajador> listaDesempleados) {

	}

	// Este me devuelve el dinero anual que a producido , quitando los gastos de
	// mantenimiento .Vamos a establecer un coste de mantenimiento anual de las
	// factorías
	// que sera un porcentaje de su producción máxima
	// De las pequeñas 15% De las medianas 10% de las grandes 5%
	public int getProduccionAnual() {
		return 0;
	}

	// devuelve el porcentaje de puestos que estan ocupados
	public float getPorcentajeCapacidad() {
		return 0;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Stack<Trabajador> getTrabajadores() {
		return trabajadores;
	}

}
