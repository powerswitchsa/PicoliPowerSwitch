package control;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.CapitalEstado;
import modelo.Ser;
import modelo.TipoSeres;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Ser> seres = new ArrayList<Ser>();

	private int id = 0;
	private int fallecidos;
	private int newJubilados;
	private int newTrabajadores;
	private int newMenores;

	public void setResetDatos() {
		this.fallecidos = 0;
		this.newJubilados = 0;
		this.newTrabajadores = 0;
		this.newMenores = 0;
	}

	public Poblacion(int menores, int desempleados, int jubilados) {
		super();
		for (int i = 0; i < menores; i++) {
			seres.add(new Ser(this.id, TipoSeres.menor, Utilies.obtenerAleatorio(0, 17)));
			this.id++;
		}
		for (int i = 0; i < desempleados; i++) {
			seres.add(new Ser(this.id, TipoSeres.desempleado, Utilies.obtenerAleatorio(18, 64)));
			this.id++;
		}
		for (int i = 0; i < jubilados; i++) {
			seres.add(new Ser(this.id, TipoSeres.jubilado, 65));
			this.id++;
		}
	}

	public void setDespedir(ArrayList<Integer> listaId) {
		if (listaId != null) {
			for (Ser ser : this.seres) {
				if (listaId.contains(ser.getId())) {
					ser.setDesempleado();
				}
			}
		}
	}

	public void setNacimientos(int numNacimientos) {
		for (int i = 0; i < numNacimientos; i++) {
			this.seres.add(new Ser(this.id, TipoSeres.menor, 0));
			this.id++;
			this.newMenores++;
		}
	}

	public ArrayList<Ser> getListTipoSer(TipoSeres tipoSer) {
		ArrayList<Ser> lista = new ArrayList<Ser>();
		for (Iterator iterator = this.seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.getTipoSer() == tipoSer) {
				lista.add(ser);
			}
		}
		return lista;
	}

	public ArrayList<Ser> getDesempleados() {
		ArrayList<Ser> lista = new ArrayList<Ser>();
		for (Iterator iterator = this.seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.getTipoSer() == TipoSeres.desempleado) {
				ser.setTrabajador();
				lista.add(ser);
			}
		}
		return lista;
	}

	public void setEnvejecerPoblacion() {
		for (Ser ser : this.seres) {
			ser.setEdad(ser.getEdad() + 1);
		}
	}

	public ArrayList<Integer> setActualizarSer() {
		ArrayList<Integer> listId = new ArrayList<Integer>();
		for (Ser ser : this.seres) {
			if (ser.getEdad() == 18 && ser.getTipoSer() == TipoSeres.menor) {
				ser.setDesempleado();
				this.newTrabajadores++;
			}
			if (ser.getEdad() == 65 && ser.getTipoSer() == TipoSeres.desempleado) {
				ser.setJubilar();
				this.newJubilados++;
			}
			if (ser.getEdad() == 65 && ser.getTipoSer() == TipoSeres.trabajador) {
				ser.setJubilar();
				listId.add(ser.getId());
				this.newJubilados++;
			}
		}
		return listId;
	}

	public ArrayList<Integer> setEliminarMuertos(CapitalEstado capitalEstado) {
		ArrayList<Integer> listId = new ArrayList<Integer>();
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.isMuerto()) {
				capitalEstado.sumarDineroEstado(ser.getAhorros());
				if (ser.getTipoSer() == TipoSeres.trabajador)
					listId.add(ser.getId());
				this.fallecidos++;
				iterator.remove();
			}
		}
		return listId;
	}

	public void setPagarMenores(CapitalEstado capitalEstado) {
		double subsidio = capitalEstado.obtenerSueldo(getNumTipoSer(TipoSeres.menor), TipoSeres.menor.getSueldo());
		for (Ser ser : seres) {
			if (ser.getTipoSer() == TipoSeres.menor)
				ser.setSubsidioMenor(subsidio);
		}
	}

	public void setPagarDesempleados(CapitalEstado capitalEstado) {
		double ayuda = capitalEstado.obtenerSueldo(getListTipoSer(TipoSeres.desempleado).size(),
				TipoSeres.desempleado.getSueldo());
		for (Ser ser : seres) {
			if (ser.getTipoSer() == TipoSeres.desempleado)
				ser.setSubsidioDesempleado(ayuda);
		}
	}

	public void setPagarTrabajadores(CapitalEstado capitalEstado) {
		double sueldo = capitalEstado.obtenerSueldo(getListTipoSer(TipoSeres.trabajador).size(),
				TipoSeres.trabajador.getSueldo());
		for (Ser ser : seres) {
			if (ser.getTipoSer() == TipoSeres.trabajador) {
				ser.setPagarTrabajador(capitalEstado, sueldo);
			}
		}
	}

	public void setPagarJubilados(CapitalEstado capitalEstado) {
		ArrayList<Ser> pensionistas = getPensionistas();
		double subsidioTotal = getSubsidioTotalJubilados(pensionistas);
		double porcentaje = capitalEstado.obtenerSubsidioJubilado(subsidioTotal);
		for (Ser ser : seres) {
			if (pensionistas.contains(ser)) {
				ser.setSubsidioJubilado(porcentaje * ser.getNVRestanteJubilado());
			}
		}
	}

	private ArrayList<Ser> getPensionistas() {
		ArrayList<Ser> pensionistas = new ArrayList<>();
		for (Ser ser : this.seres) {
			if (ser.getTipoSer() == TipoSeres.jubilado && ser.getNVRestanteJubilado() > 0) {
				pensionistas.add(ser);
			}
		}
		return pensionistas;
	}

	private double getSubsidioTotalJubilados(ArrayList<Ser> pensionistas) {
		double retorno = 0;
		for (Ser ser : seres) {
			if (ser.getTipoSer() == TipoSeres.jubilado) {
				double dinero = ser.getNVRestanteJubilado();
				if (dinero != 0) {
					pensionistas.add(ser);
					retorno += dinero;
				}
			}
		}
		return retorno;
	}

	public int getNumTipoSer(TipoSeres tipoSeres) {
		int contador = 0;
		for (Ser ser : seres) {
			if (ser.getTipoSer() == tipoSeres) {
				contador++;
			}
		}
		return contador;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getFallecidos() {
		return fallecidos;
	}

	public int getNewJubilados() {
		return newJubilados;
	}

	public int getNewTrabajadores() {
		return newTrabajadores;
	}

	public int getNewMenores() {
		return newMenores;
	}

	public ArrayList<Ser> getSeres() {
		return seres;
	}

	public void setNewMenores(int newMenores) {
		this.newMenores = newMenores;
	}

}
