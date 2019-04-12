package modelo.listas;

import java.util.ArrayList;
import java.util.HashSet;

import modelo.factorias.Factoria;
import modelo.seres.Trabajador;

public class Industria {

	private ArrayList<Factoria> factorias;

	public Industria() {
		super();
		this.factorias = new ArrayList<>();
	}

	public long getProduccionTotal() {
		return 0;
	}

	public void cerrarFactorias(HashSet<Trabajador> listaDesempleados) {

	}

	public void despedir(HashSet<Trabajador> listaDesempleados, int numTrabajadores) {

	}

	public void eliminarTrabajador(int id) {

	}

	public void contratar(Trabajador trabajador) {

	}

	public ArrayList<Factoria> getFactorias() {
		return factorias;
	}

}
