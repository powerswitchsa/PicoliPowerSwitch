package modelo;

import interfaz.Cobrable;
import interfaz.Morible;
import modelo.seres.Jubilado;
import utilesglobal.Utilies;

public abstract class Ser implements Cobrable, Morible {

	private String nombre;
	private int id;
	private int edad;
	private int fechaMuerte;

	private double ahorros;
	private double necesidadVital;

	public Ser(String nombre, int id) {
		super();
		this.nombre = Utilies.getNombreAleatorio();
		this.id = id;
		this.necesidadVital = 365;
		this.fechaMuerte = Utilies.obtenerAleatorio(90);
	}

	public Ser() {
		super();
	}
	
	public void reducirEsperanzaVida(double NVrestante) {
		double maxPierde = 0.5;
		double cuenta = (0.5 * NVrestante) / this.necesidadVital;
		this.fechaMuerte -= cuenta;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(int fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public double getNecesidadVital() {
		return necesidadVital;
	}

	public void setNecesidadVital(float necesidadVital) {
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
