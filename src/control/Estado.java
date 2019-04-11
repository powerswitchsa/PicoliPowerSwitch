package control;

import java.util.HashSet;

import modelo.factorias.Factoria;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Estado {

	private HashSet<Menor> listaMenor;
	private HashSet<Trabajador> listaTrabajadorParo;
	private HashSet<Jubilado> listaJubilados;
	private HashSet<Factoria> listaFactoria;

}
