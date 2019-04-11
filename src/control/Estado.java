package control;

import java.util.HashSet;
import java.util.Stack;

import modelo.factorias.Factoria;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Estado {

	private Stack<Trabajador> listaDesenpleados;
	private HashSet<Menor> listaMenor;
	private HashSet<Jubilado> listaJubilados;
	private HashSet<Factoria> listaFactoria;

	public Estado() {
		super();
		this.listaDesenpleados = new Stack<Trabajador>();
		this.listaMenor = new HashSet<Menor>();
		this.listaJubilados = new HashSet<Jubilado>();
		this.listaFactoria = new HashSet<Factoria>();
	}

}
