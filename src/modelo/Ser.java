package modelo;

import interfaz.Cobrable;
import interfaz.Morible;

public abstract class Ser implements Cobrable, Morible {

	private String nombre;
	private int id;
	private int edad;
	private int fechaMuerte;

	private double ahorros;
	private int necesidadVital;
	private double sueldoMinimoVivir;

	public Ser(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.necesidadVital = 365;
		this.fechaMuerte = obtenerNumeroAleatorio(0, 89);
	}

	public Ser() {
		super();
	}

	private int obtenerNumeroAleatorio(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSueldoMinimoVivir(double suledoMinimoVivir) {
		this.sueldoMinimoVivir = suledoMinimoVivir;
	}

	public int getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(int fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public int getNecesidadVital() {
		return necesidadVital;
	}

	public void setNecesidadVital(int necesidadVital) {
		this.necesidadVital = necesidadVital;
	}

	public double getAhorros() {
		return ahorros;
	}

	public void setAhorros(double ahorros) {
		this.ahorros = ahorros;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

}
