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
		int numDesempleados = desempleados;
		for (int i = this.factorias.size() - 1; i >= 0; i--) {
			if (numDesempleados == 0)
				continue;
			if (this.factorias.get(i).getTrabajadores().size() > numDesempleados) {
				listaId.addAll(this.factorias.get(i).setDespedirTrabajadores(numDesempleados));
				if (this.factorias.get(i).getTrabajadores().size() == 0)
					this.factorias.remove(this.factorias.get(i));
			} else {
				int cuenta = numDesempleados - this.factorias.get(i).getTrabajadores().size();
				listaId.addAll(this.factorias.get(i).setDespedirTrabajadores(cuenta));
				numDesempleados = cuenta;
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

	public boolean setContratarDesempleados(ArrayList<Ser> desempleados) {
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
		return false;
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
