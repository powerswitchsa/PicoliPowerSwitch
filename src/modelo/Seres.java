package modelo;

import interfaz.Cobrable;

public abstract class Seres implements Cobrable {

	private String nombre;
	private int id;
	private int edad;
	private int fechaMuerte;
	private double ahorros;

	private int necesidadVital;
	private double sueldoMinimoVivir;

	public Seres(String nombre) {
		super();
		this.nombre = nombre;
		this.necesidadVital = 365;
		this.fechaMuerte = obtenerNumeroAleatorio(0, 89);
	}

	public Seres() {
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
