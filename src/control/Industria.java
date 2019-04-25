package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import modelo.Factoria;
import modelo.Ser;
import modelo.TipoSeres;

public class Industria {

	private ArrayList<Factoria> factorias;

	public Industria() {
		super();
		this.factorias = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			crearNuevaFactoria();
		}
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
			for (Iterator iterator = fact.getTrabajadores().iterator(); iterator.hasNext();) {
				Ser ser = (Ser) iterator.next();
				if (listaId.contains(ser.getId())) {
					iterator.remove();
				}
			}
		}
	}

	public void contratar(ArrayList<Ser> desempleados) {
		int indice = 0;
		for (Ser ser : desempleados) {
			indice = 0;
			for (Factoria fact : factorias) {
				if (fact.getTrabajadores().size() <= 1000 && indice != 1) {
					fact.contratarTrabajador(ser);
					indice++;
				}
			}
		}
	}

	public int getNumTrabajadores() {
		int contador = 0;
		for (Factoria fact : this.factorias) {
			contador += fact.getTrabajadores().size();
		}
		return contador;
	}

	public void despedir(HashSet<Ser> listaDesempleados, int numTrabajadores) {

	}

	private void crearNuevaFactoria() {
		this.factorias.add(new Factoria());
	}

	public ArrayList<Factoria> getFactorias() {
		return factorias;
	}

}
