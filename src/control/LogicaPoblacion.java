package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.CapitalEstado;
import modelo.Ser;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class LogicaPoblacion {

	private int id = 0;
	private int fallecidos;
	private int newJubilados;
	private int newTrabajadores;
	private int newMenores;

	public ArrayList<Menor> getMenor(ArrayList<Ser> seres) {
		ArrayList<Menor> menores = new ArrayList<Menor>();
		for (Ser ser : seres) {
			if (ser instanceof Menor) {
				menores.add((Menor) ser);
			}
		}
		return menores;
	}

	public Stack<Trabajador> getTrabajadoresDesempleados(ArrayList<Ser> seres) {
		Stack<Trabajador> trabajadores = new Stack<Trabajador>();
		for (Ser ser : seres) {
			if (ser instanceof Trabajador && !((Trabajador) ser).isTrabajando()) {
				trabajadores.add((Trabajador) ser);
			}
		}
		return trabajadores;
	}

	public ArrayList<Jubilado> getJubilado(ArrayList<Ser> seres) {
		ArrayList<Jubilado> jubilados = new ArrayList<Jubilado>();
		for (Ser ser : seres) {
			if (ser instanceof Jubilado) {
				jubilados.add((Jubilado) ser);
			}
		}
		return jubilados;
	}

	public void envejecerPoblacion(ArrayList<Ser> seres) {
		for (Ser ser : seres) {
			ser.setEdad(ser.getEdad() + 1);
		}
	}

	public void actualizarSer(Industria industria, ArrayList<Ser> seres) {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser instanceof Menor && ser.getEdad() == 18) {
				seres.add(new Trabajador(ser.getNombre(), ser.getId()));
				seres.remove(ser);
				this.newTrabajadores++;
			}
			if (ser instanceof Trabajador && ser.getEdad() == 64) {
				seres.add(new Jubilado(ser.getNombre(), ser.getId(), ser.getAhorros()));
				industria.eliminarTrabajador(ser.getId());
				seres.remove(ser);
				this.newJubilados++;
			}
		}
	}

	public void eliminarMuertos(CapitalEstado capitalEstado, Industria industria, ArrayList<Ser> seres) {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.morir()) {
				if (ser instanceof Trabajador && ((Trabajador) ser).isTrabajando()) {
					industria.eliminarTrabajador(ser.getId());
				}
				capitalEstado.sumarDineroEstado(ser.getAhorros());
				seres.remove(ser);
				this.fallecidos++;
			}
		}
	}

	public void pagarMenores(double sueldo, ArrayList<Ser> seres, CapitalEstado capitalEstado) {
		for (Ser ser : seres) {
			if (ser instanceof Menor)
				ser.cobrar(sueldo, capitalEstado);
		}
	}

	public void pagarDesempleados(double sueldo, ArrayList<Ser> seres, CapitalEstado capitalEstado) {
		for (Ser ser : seres) {
			if (ser instanceof Trabajador && !((Trabajador) ser).isTrabajando())
				ser.cobrar(sueldo, capitalEstado);
		}
	}

	public void pagarTrabajadores(double sueldo, ArrayList<Ser> seres, CapitalEstado capitalEstado) {
		for (Ser ser : seres) {
			if (ser instanceof Trabajador && ((Trabajador) ser).isTrabajando())
				ser.cobrar(sueldo, capitalEstado);
		}
	}

	public void pagarJubilados(double sueldo, ArrayList<Ser> seres, CapitalEstado capitalEstado) {
		for (Ser ser : seres) {
			if (ser instanceof Menor)
				ser.cobrar(sueldo, capitalEstado);
		}
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

}
