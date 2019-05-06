package control;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Factoria;
import modelo.Ser;

public class Industria {

	private ArrayList<Factoria> factorias;

	public Industria() {
		super();
		this.factorias = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			crearNuevaFactoria();
		}
	}

	public void setEliminarFactoriasVacias() {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factoria factoria = (Factoria) iterator.next();
			if (factoria.getTrabajadores().isEmpty())
				iterator.remove();
		}
	}

	public ArrayList<Integer> setDespedirEmpleados(int desempleados) {
		ArrayList<Integer> listaId = new ArrayList<Integer>();
		int contador = 0;
		for (Iterator iterator = this.factorias.iterator(); iterator.hasNext();) {
			Factoria fact = (Factoria) iterator.next();
			if (contador == desempleados)
				break;
			for (Iterator iterator2 = fact.getTrabajadores().iterator(); iterator2.hasNext();) {
				Ser ser = (Ser) iterator2.next();
				listaId.add(ser.getId());
				iterator2.remove();
				contador++;
				if (contador == desempleados)
					break;
			}
		}
		return listaId;
	}

	public void setEliminarTrabajadores(ArrayList<Integer> listaId) {
		for (Factoria fact : this.factorias) {
			for (Iterator iterator = fact.getTrabajadores().iterator(); iterator.hasNext();) {
				Ser ser = (Ser) iterator.next();
				if (listaId.contains(ser.getId())) {
					iterator.remove();
				}
			}
		}
	}

	public void setContratarDesempleados(ArrayList<Ser> desempleados) {
		boolean salir = false;
		do {
			salir = getNumPuestosVacantes() < desempleados.size() ? crearNuevaFactoria() : true;
		} while (!salir);
		for (Iterator iterator = desempleados.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			for (Iterator iterator2 = this.factorias.iterator(); iterator2.hasNext();) {
				Factoria fact = (Factoria) iterator2.next();
				if (fact.getPuestoVacantes() > 0) {
					fact.setContratarTrabajador(ser);
					break;
				}
			}
		}
	}

	public double getProduccionTotal() {
		double retorno = 0;
		for (Factoria factoria : factorias) {
			retorno += factoria.getProduccionAnual();
		}
		return retorno;
	}

	private int getNumPuestosVacantes() {
		int vacantes = 0;
		for (Factoria fact : this.factorias) {
			vacantes += fact.getPuestoVacantes();
		}
		return vacantes;
	}

	public int getNumTrabajadores() {
		int contador = 0;
		for (Factoria fact : this.factorias) {
			contador += fact.getTrabajadores().size();
		}
		return contador;
	}

	private boolean crearNuevaFactoria() {
		this.factorias.add(new Factoria());
		return false;
	}

	public ArrayList<Factoria> getFactorias() {
		return factorias;
	}

}
