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

	public void actualizarPoblacion(long dineroEstado, Industria industria, long nacimientos) {
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

	// si se muere el un trabajador que no este desempleado, aparte de eliminarlo de
	// la lista de poblacion, hay que eliminarlo de la factoria en la que trabaja
	// el dinero que tenga ahorrado pasa al estado
	private void eliminarMuertos(long dineroEstado, Industria industria) {

	}

	// utilizar interfaz "Cobrable"
	private void pagarSueldos(long dineroEstado) {

	}
}
