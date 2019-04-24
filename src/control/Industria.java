package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import modelo.Factoria;
import modelo.Ser;
import modelo.TipoSeres;

public class Industria {

	private ArrayList<Factoria> factorias;

	public Industria() {
		super();
		this.factorias = new ArrayList<>();
		this.factorias.add(new Factoria());
	}

	public double getProduccionTotal() {
		double retorno = 0;
		for (Factoria factoria : factorias) {
			retorno += factoria.getProduccionAnual();
		}
		return retorno;
	}

	public void cerrarFactorias(Stack<Ser> listaDesempleados) {
		for (Factoria factoria : factorias) {
			if (factoria.getTrabajadores().isEmpty()) {
				factoria.cerraFactoria(listaDesempleados);
				factorias.remove(factoria);
			}
		}
	}

	public void eliminarTrabajadores(ArrayList<Integer> listaId) {
		for (Factoria fact : this.factorias) {
			for (Ser ser : fact.getTrabajadores()) {
				if (listaId.contains(ser.getId())) {
					fact.getTrabajadores().remove(ser);
				}
			}
		}
	}

	public void crearNuevaFactoria() {
		this.factorias.add(new Factoria());
	}

	public ArrayList<Factoria> getFactorias() {
		return factorias;
	}

	public void contratar(Stack<Ser> desempleados, ArrayList<Ser> seres) {

	}

	public void despedir(HashSet<Ser> listaDesempleados, int numTrabajadores) {

	}

}
