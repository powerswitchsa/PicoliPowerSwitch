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

	private int sueldoTrabajadores = 730;
	private int sueldoMenor = 365;

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
		this.poblacion.pagarPoblacion(dineroEstado, obtenerSueldo(this.menores.size(), 365), Menor.class);
		this.poblacion.pagarPoblacion(dineroEstado, obtenerSueldo(this.desempleados.size(), 182.5), Trabajador.class);
		this.poblacion.pagarPoblacion(dineroEstado, obtenerSueldo(this.industria.getNumTrabajdores(), 730),
				Trabajador.class);
		this.poblacion.pagarPoblacion(dineroEstado, obtenerSueldo(this.jubilados.size(), 91.25), Jubilado.class);
		this.poblacion.actualizarPoblacion(dineroEstado, industria, nacimientos);
		this.desempleados = poblacion.getTrabajadores();
		this.menores = poblacion.getMenor();
		this.jubilados = poblacion.getJubilado();
	}

	private double obtenerSueldo(int numSeres, double sueldo) {
		double dineroNecesario = numSeres * sueldo;
		if (dineroNecesario > this.dineroEstado) {
			return this.dineroEstado / numSeres;
		} else {
			this.dineroEstado -= dineroNecesario;
			return sueldo;
		}
	}

}
