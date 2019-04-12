package modelo.listas;

import java.util.HashSet;

import modelo.factorias.Factoria;
import modelo.seres.Trabajador;

public class Industria {

	private HashSet<Factoria> factorias;

	public Industria() {
		super();
		this.factorias = new HashSet<>();
	}

	public long getProduccionTotal() {
		return 0;
	}

	public void cerrarFactorias(HashSet<Trabajador> listaDesempleados) {

	}

	public void despedir(HashSet<Trabajador> listaDesempleados, int numTrabajadores) {

	}

	public HashSet<Factoria> getFactorias() {
		return factorias;
	}

}
