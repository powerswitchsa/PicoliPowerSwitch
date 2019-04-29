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
		this.fechaMuerte = 90;
		this.fechaMuerte = Utilies.obtenerAleatorio((int) this.edad, 90);
		this.tipoSer = tipo;
	}

	public double getNVRestanteJubilado() {
		double dineroNecesario = this.tipoSer.getNV() - this.ahorros;
		dineroNecesario = dineroNecesario > 0 ? dineroNecesario : 0;
		if (dineroNecesario >= this.tipoSer.getNV() / 2)
			dineroNecesario = this.tipoSer.getNV() / 2;
		return dineroNecesario;
	}

	public void setPagarTrabajador(CapitalEstado capitalEstado, double pagaEstado) {
		if (pagaEstado < this.tipoSer.getNV()) {
			setReducirEsperanzaVida(this.tipoSer.getNV() - pagaEstado);
		} else {
			double sueldoRestante = pagaEstado - this.tipoSer.getNV();
			this.ahorros += sueldoRestante / 2;
			capitalEstado.sumarDineroEstado(sueldoRestante / 2);
		}
	}

	public void setSubsidioMenor(double paga) {
		if (paga < this.tipoSer.getNV())
			setReducirEsperanzaVida(this.tipoSer.getNV() - paga);
	}

	public void setSubsidioDesempleado(double ayudaEstado) {
		double NVRestante = this.tipoSer.getNV() - ayudaEstado;
		if (NVRestante < this.ahorros) {
			this.ahorros -= NVRestante;
		} else {
			NVRestante -= this.ahorros;
			this.ahorros = 0;
			setReducirEsperanzaVida(NVRestante);
		}
	}

	public void setSubsidioJubilado(double subsudio) {
		if (this.ahorros >= this.tipoSer.getNV()) {
			this.ahorros -= this.tipoSer.getNV();
		} else {
			double dinero = this.tipoSer.getNV() - this.ahorros;
			this.ahorros = 0;
			dinero -= subsudio;
			if (dinero > 0) {
				setReducirEsperanzaVida(dinero);
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

	public void setReducirEsperanzaVida(double NVrestante) {
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
