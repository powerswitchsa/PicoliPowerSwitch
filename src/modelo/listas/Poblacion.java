package modelo.listas;

import java.util.ArrayList;
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
		pagarSueldos(dineroEstado);
		eliminarMuertos(dineroEstado, industria);
		aumentarPoblacion(nacimientos);
		actualizarSer();
	}

	// retorna la suma total de todos los sueldos que debemos pagar
	// incluyendo a los jubilados
	public long getObtenerDemandaSueldos() {
		return 0;
	}

	// comprueba si el ser pasar a ser trabajador o jubilado
	private void actualizarSer() {

	}

	// menores que añadimos a la lista
	private void aumentarPoblacion(long nacimientos) {

	}

	// si muere un trabajador que no este desempleado, aparte de eliminarlo de
	// la lista de poblacion, hay que eliminarlo de la factoria en la que trabaja.
	// Los que tengan ahorros estos pasan al estado
	private void eliminarMuertos(Double dineroEstado, Industria industria) {

	}

	// utilizar interfaz "Cobrable"
	// Sueldos :
	// TRABAJADOR --> 730$ --> SIN TRAABAJO Y AHORROS , LES AYUDA EL ESTADO , PERO
	// ESTE SOLO LE PAGA 50% DE SU NECESIDAD VITAL
	// MENOR --> 365$ --> LOS MANTIENEN EL ESTADO
	// JUBILADO --> 182.5$ --> CUANDO SE QUEDAN SIN AHORROS
	private void pagarSueldos(Double dineroEstado) {

	}
}
