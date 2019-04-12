package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import modelo.factorias.Factoria;
import modelo.listas.Industria;
import modelo.listas.Poblacion;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Estado {

//	Sueldos :
// 	TRABAJADOR --> 730$ --> LES PAGA LA EMPRESA / SIN TRAABAJO Y AHORROS , LES AYUDA EL ESTADO
// 	MENOR --> 365$ --> LOS MANTIENEN EL ESTADO
// 	JUBILADO --> 182.5$ --> CUANDO SE QUEDAN SIN AHORROS

	private Poblacion poblacion;
	private Industria industria;

	private Stack<Trabajador> desempleados;
	private ArrayList<Menor> menores;
	private ArrayList<Jubilado> jubilados;

	private long dineroEstado;
	private long nacimientos;

	public Estado() {
		super();
		this.poblacion = new Poblacion(30, 100, 20);
		this.desempleados = poblacion.getTrabajadores();
		this.menores = poblacion.getMenor();
		this.jubilados = poblacion.getJubilado();
	}

	public void actualizarListas() {
		poblacion.actualizarPoblacion(dineroEstado, industria, nacimientos);
		this.desempleados = poblacion.getTrabajadores();
		this.menores = poblacion.getMenor();
		this.jubilados = poblacion.getJubilado();
	}

	// Este llamara al metodo cobrar de cada objeto "Seres"
	// Este es el orden en el que cobraran : menores , trabajadores , jubilados
	public void pagarSeres() {

	}

	// Obtiene la produccion de todas las factorias, y actualiza "dineroEstado"
	public void getDineroFactorias() {

	}
}
