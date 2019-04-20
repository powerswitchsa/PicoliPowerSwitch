package modelo.listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.Ser;
import modelo.seres.Jubilado;
import modelo.seres.Menor;
import modelo.seres.Trabajador;

public class Poblacion {

	private int id = 0;
	private ArrayList<Ser> seres;

	public Poblacion(int numMenor, int numTrabajadores, int numJubilados) {
		super();
		this.seres = new ArrayList<>();

	}

	public ArrayList<Menor> getMenor() {
		return null;
	}

	public Stack<Trabajador> getTrabajadores() {
		return null;
	}

	public ArrayList<Jubilado> getJubilado() {
		return null;
	}

	public void actualizarPoblacion(Double dineroEstado, Industria industria, long nacimientos) {
		envejecerPoblacion();
		eliminarMuertos(dineroEstado, industria);
		aumentarPoblacion(nacimientos);
		actualizarSer();
	}

	private void envejecerPoblacion() {
		for (Ser ser : seres) {
			ser.setEdad(ser.getEdad() + 1);
		}
	}

	// retorna la suma total de todos los sueldos que debemos pagar
	// incluyendo a los jubilados
	public long getObtenerDemandaSueldos() {
		return 0;
	}

	// comprueba si el ser pasar a ser trabajador o jubilado
	private void actualizarSer() {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.getEdad() == 18) {
				seres.add(new Trabajador(ser.getNombre(), ser.getId()));
				seres.remove(ser);
			}
			if (ser.getEdad() == 64) {
				seres.add(new Jubilado(ser.getNombre(), ser.getId(), ser.getAhorros()));
				seres.remove(ser);
			}
		}

	}

	// menores que añadimos a la lista
	private void aumentarPoblacion(long nacimientos) {

	}

	// si muere un trabajador que no este desempleado, aparte de eliminarlo de
	// la lista de poblacion, hay que eliminarlo de la factoria en la que trabaja.
	// Los que tengan ahorros estos pasan al estado
	private void eliminarMuertos(Double dineroEstado, Industria industria) {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			if (ser.morir()) {
				if (ser instanceof Trabajador && ((Trabajador) ser).isTrabajando()) {
					industria.eliminarTrabajador(ser.getId());
				}
				dineroEstado += ser.getAhorros();
				seres.remove(ser);
			}
		}
	}

	// utilizar interfaz "Cobrable"
	// Sueldos :
	// TRABAJADOR --> 730$ --> SIN TRAABAJO Y AHORROS , LES AYUDA EL ESTADO , PERO
	// ESTE SOLO LE PAGA 50% DE SU NECESIDAD VITAL
	// MENOR --> 365$ --> LOS MANTIENEN EL ESTADO
	// JUBILADO --> 182.5$ --> CUANDO SE QUEDAN SIN AHORROS
	public void pagarPoblacion(Double dineroEstado, double sueldo, Object tipoSer) {
		for (Ser ser : seres) {
			if (tipoSer.getClass() == ser.getClass()) {
				ser.cobrar(sueldo, dineroEstado);
			}
		}
	}

}
