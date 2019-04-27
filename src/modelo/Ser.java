package modelo;

import utilesglobal.Utilies;

public class Ser {

	private String nombre;
	private int id;
	private TipoSeres tipoSer;
	private double fechaMuerte;
	private double edad;
	private double ahorros;

	public Ser(int id) {
		super();
		this.id = id;
		this.nombre = Utilies.getNombreAleatorio();
		this.fechaMuerte = Utilies.obtenerAleatorio(90);
		this.tipoSer = TipoSeres.menor;
		this.edad = 0;
	}

	public Ser(int id, TipoSeres tipo, double edad) {
		super();
		this.id = id;
		this.nombre = Utilies.getNombreAleatorio();
		this.edad = edad;
//		this.fechaMuerte = Utilies.obtenerAleatorio((int) this.edad, 90);
		this.fechaMuerte = 90;
		this.tipoSer = tipo;
	}

	public double getNVRestanteJubilado() {
		double dineroNecesario = this.tipoSer.getNV() - this.ahorros;
		dineroNecesario = dineroNecesario > 0 ? dineroNecesario : 0;
		if (dineroNecesario >= this.tipoSer.getNV() / 2)
			dineroNecesario = this.tipoSer.getNV() / 2;
		return dineroNecesario;
	}

	public void pagarTrabajador(CapitalEstado capitalEstado, double pagaEstado) {

	}

	public void subsidioMenor(double paga) {
		if (paga < this.tipoSer.getNV())
			reducirEsperanzaVida(this.tipoSer.getNV() - paga);
	}

	public void subsidioDesempleado(double ayudaEstado) {

	}

	public void subsidioJubilado(double subsudio) {
		if (this.ahorros >= this.tipoSer.getNV()) {
			this.ahorros -= this.tipoSer.getNV();
		} else {
			double dinero = this.tipoSer.getNV() - this.ahorros;
			this.ahorros = 0;
			dinero -= subsudio;
			if (dinero > 0) {
				reducirEsperanzaVida(dinero);
			}
		}
	}

	public void setDesempleado() {
		this.tipoSer = TipoSeres.desempleado;
	}

	public void setTrabajador() {
		this.tipoSer = TipoSeres.trabajador;
	}

	public void setJubilar() {
		this.tipoSer = TipoSeres.jubilado;
	}

	public void reducirEsperanzaVida(double NVrestante) {
		this.fechaMuerte -= (((NVrestante * 100) / this.tipoSer.getNV()) * 0.5) / 100;
	}

	public boolean isMuerto() {
		return (this.edad >= this.fechaMuerte);
	}

	public boolean isTipo(TipoSeres tipoSeres) {
		return this.tipoSer == tipoSeres;
	}

	// getters y setters
	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public double getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(int fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
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

	public TipoSeres getTipoSer() {
		return tipoSer;
	}

	public void setTipoSer(TipoSeres tipoSer) {
		this.tipoSer = tipoSer;
	}

}
