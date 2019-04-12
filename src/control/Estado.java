package control;

import java.util.HashSet;
import java.util.Stack;

import modelo.factorias.Factoria;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Estado {

//	Sueldos :
// 	TRABAJADOR --> 730$ --> LES PAGA LA EMPRESA / SIN TRAABAJO Y AHORROS , LES AYUDA EL ESTADO
// 	MENOR --> 365$ --> LOS MANTIENEN EL ESTADO
// 	JUBILADO --> 182.5$ --> CUANDO SE QUEDAN SIN AHORROS

	private Stack<Trabajador> listaDesenpleados;
	private HashSet<Menor> listaMenor;
	private HashSet<Jubilado> listaJubilados;
	private HashSet<Factoria> listaFactoria; // los que estan trabajando

	private long dineroEstado;

	public Estado() {
		super();
		this.listaDesenpleados = new Stack<Trabajador>();
		this.listaMenor = new HashSet<Menor>();
		this.listaJubilados = new HashSet<Jubilado>();
		this.listaFactoria = new HashSet<Factoria>();
	}

	// Eliminar aquellos que mueran (Si el ser muere y tiene ahorros pasan a ser propiedad del estado.)
	// Pasar menor a desempleado si estos cumplen las condiciones
	// Añadir nuevos menores (la cantidad dependera de la demanda)
	public void actualizarMenores() {

	}

	// Eliminar aquellos que mueran (Si el ser muere y tiene ahorros pasan a ser propiedad del estado.)
	// Pasar trabajadores a jubilados si estos cumplen las condiciones (Cuando un trabajador se jubila su NV decrece al 50%)
	public void actualizarTrabajadores() {

	}

	// Eliminar aquellos que mueran (Si el ser muere y tiene ahorros pasan a ser propiedad del estado.)
	public void actualizarJubilados() {

	}

	// Este llamara al metodo cobrar de cada objeto "Seres"
	// Este es el orden en el que cobraran : menores , trabajadores , jubilados
	public void pagarSeres() {

	}

	// Obtiene la produccion de todas las factorias, y actualiza "dineroEstado"
	public void getDineroFactorias() {

	}
}
