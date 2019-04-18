package control;

import java.util.ArrayList;
import java.util.Stack;

import modelo.listas.Industria;
import modelo.listas.Poblacion;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Estado {

	private Poblacion poblacion;
	private Industria industria;

	private Stack<Trabajador> desempleados;
	private ArrayList<Menor> menores;
	private ArrayList<Jubilado> jubilados;

	private double dineroEstado;
	private long nacimientos;

	public Estado() {
		super();
		this.poblacion = new Poblacion(30, 100, 20);
		this.desempleados = poblacion.getTrabajadores();
		this.menores = poblacion.getMenor();
		this.jubilados = poblacion.getJubilado();
	}

	public void actualizarListas() {
		this.dineroEstado = industria.getProduccionTotal();
		this.poblacion.actualizarPoblacion(dineroEstado, industria, nacimientos);
		this.desempleados = poblacion.getTrabajadores();
		this.menores = poblacion.getMenor();
		this.jubilados = poblacion.getJubilado();
	}

}
